package hu.bme.mit.inf.ptregex2automaton.tests

import EventAutomatonModel.ComplexEventProcessor
import EventAutomatonModel.Event
import EventAutomatonModel.EventAutomatonModelFactory
import com.google.inject.Injector
import hu.bme.mit.inf.ParametricTimedRegularExpressionStandaloneSetup
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel
import hu.bme.mit.inf.ptregex2automaton.RegexCompiler
import hu.bme.mit.inf.qea.CEPExecutor
import hu.bme.mit.inf.vepl2ptregex.VeplCompiler
import java.io.ByteArrayInputStream
import java.io.IOException
import java.util.Collections
import java.util.Map
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.cep.vepl.VeplStandaloneSetup
import org.eclipse.viatra.cep.vepl.vepl.EventModel
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Assert

class TestUtils {
	static val Injector RegexInjector = new ParametricTimedRegularExpressionStandaloneSetup().
		createInjectorAndDoEMFRegistration();
		static val Injector VeplInjector = new VeplStandaloneSetup().createInjectorAndDoEMFRegistration();

		def protected static RegexModel parseRegex(CharSequence input) {
			return parseRegex(input.toString)
		}

		def protected static EventModel parseVepl(CharSequence input) {
			return parseVepl(input.toString)
		}

		def protected static RegexModel parseRegex(String input) {
			val resourceSet = RegexInjector.getInstance(XtextResourceSet)
			val resource = resourceSet.createResource(URI.createURI("dummy:/temp.ptreg"))
			resource.load(new ByteArrayInputStream(input.getBytes), #{})
			Assert.assertEquals('File can not be parsed', 0, resource.getErrors.length)
			val parsed = (resource.contents.get(0) as RegexModel)
			return parsed;
		}

		def protected static EventModel parseVepl(String input) {
			val resourceSet = VeplInjector.getInstance(XtextResourceSet)
			val resource = resourceSet.createResource(URI.createURI("dummy:/temp.vepl"))
			resource.load(new ByteArrayInputStream(input.getBytes), #{})
			Assert.assertEquals('File can not be parsed', 0, resource.getErrors.length)
			val parsed = (resource.contents.get(0) as EventModel)
			return parsed;
		}

		def protected static ComplexEventProcessor compile(RegexModel input) {
			val compiler = new RegexCompiler()
			val compiled = compiler.compile(input)
			compiler.tgfLogs.forEach [ automaton, log |
				log("compilation_" + automaton.name + ".tgf", log.toString)
			]
			return compiled
		}

		def protected static Event getEventByName(ComplexEventProcessor model, String name) {
			val retvalue = EventAutomatonModelFactory.eINSTANCE.createEvent
			retvalue.type = model.symbolicEvents.findFirst[it.name.equals(name)]
			return retvalue
		}

		def protected static void testRegex(ComplexEventProcessor model, String input) {
			val exec = new TestExecutor(model)

			var processedInputs = 0
			var lastEvent = " "
			for (word : input.trim.split('\\s').map[it.trim].filter[!it.equals('')]) {
				if (word.startsWith('*')) {
					val expressionName = word.substring(1)
					if (!exec.acceptedLastTime(expressionName)) { // XXX we first check, print the trace, and assert later
						val callingFunctionName = Thread.currentThread().getStackTrace().get(3).methodName
						log(callingFunctionName + '.txt', exec.exec.log.toString)
					}
					Assert.assertEquals(
						("Assertion failed at input " + lastEvent + " #" + processedInputs + " on pattern " +
							expressionName),
						true,
						exec.acceptedLastTime(expressionName)
					)
				} else {
					exec.pushEvent(word)
					processedInputs++
					lastEvent = word
				}
			}
			val callingFunctionName = Thread.currentThread().getStackTrace().get(3).methodName

			log(callingFunctionName + '.txt', exec.exec.log.toString)
		}

		def static void testRegex(String regex, String input) {
			val model = regex.parseRegex.compile

			var Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE
			var Map<String, Object> m = reg.getExtensionToFactoryMap()
			m.put("ptregex", new XMIResourceFactoryImpl())
			
			var ResourceSet resSet=new ResourceSetImpl() 
			var Resource resource=resSet.createResource(URI.createURI("test.ptregex")) 
			resource.getContents().add(model) 
			try {
				resource.save(Collections.EMPTY_MAP) 
			} catch (IOException e) {
				e.printStackTrace() 
			}

			testRegex(model, input)
		}

		def protected static RegexModel compile(EventModel em) {
			val compiler = new VeplCompiler()
			val compiled = compiler.compile(em)
			return compiled
		}

		def public static void testVepl(String vepl, String input) {
			val model = vepl.parseVepl.compile.compile
			testRegex(model, input)
		}

		def public static void log(String fileName, String fileContent) {
			var timestamp = (System.currentTimeMillis() / 1000L) as int;

			var IWorkspace workspace = ResourcesPlugin.getWorkspace();
			var IWorkspaceRoot root = workspace.getRoot();
			var IProject project = root.getProject("hu.bme.mit.inf.ptregex2automaton.tests");
			var IFolder folder = project.getFolder("debug");
			var IFile file = folder.getFile(timestamp + '_' + fileName);
			if (!project.exists()) {
				project.create(null);
			}
			if (!project.isOpen()) {
				project.open(null);
			}
			if (!folder.exists()) {
				folder.create(IResource.NONE, true, null);
			}
			if (!file.exists()) {
				var bytes = fileContent.getBytes();
				var source = new ByteArrayInputStream(bytes);
				file.create(source, IResource.NONE, null);
			}
		}
	}

	class TestExecutor {
		public val CEPExecutor exec
		public val ComplexEventProcessor model

		new(ComplexEventProcessor input) {
			exec = new CEPExecutor(input)
			model = input
		}

		def pushEvent(Event e) {
			exec.pushEvent(e)
		}

		def pushEvent(String eventName) {
			val newEvent = EventAutomatonModelFactory.eINSTANCE.createEvent
			newEvent.type = model.symbolicEvents.findFirst[it.name.equals(eventName)]
			if (newEvent.type == null) {
				throw new Exception('There is no event named ' + eventName)
			}
			pushEvent(newEvent)
		}

		def acceptedLastTime(String name) {
			val expression = model.automata.findFirst[it.name.equals(name)]
			if (expression == null) {
				Assert.fail('There is no expression called ' + name)
			}
			return expression.states.findFirst[it.acceptor && it.tokens.length > 0] != null
		}

	}
	