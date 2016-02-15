package hu.bme.mit.inf.ptregex2automaton.tests

import com.google.inject.Injector
import hu.bme.mit.inf.ParametricTimedRegularExpressionStandaloneSetup
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel
import java.io.ByteArrayInputStream
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.emf.common.util.URI
import hu.bme.mit.inf.ptregex2automaton.RegexCompiler
import hu.bme.mit.inf.qea.CEPExecutioner
import EventAutomatonModel.EventAutomatonModelFactory
import EventAutomatonModel.Event
import EventAutomatonModel.ComplexEventProcessor

class TestUtils {
	def static void main(String[] input2){
		val compiled = '''
		alphabet = {A, B}
		expression foo = A B
		expression bar = A | B'''.parse.compile
		
		var exec = new TestExecutioner(compiled)
		exec.pushEvent('B')
		exec.pushEvent('A')
		
	}
	

	def static RegexModel parse(CharSequence input){
		return parse(input.toString)
	}
	
	def static RegexModel parse(String input){
		var Injector injector = new ParametricTimedRegularExpressionStandaloneSetup().createInjectorAndDoEMFRegistration();		
		val resourceSet = injector.getInstance(XtextResourceSet)
		val resource = resourceSet.createResource(URI.createURI("dummy:/temp.ptreg"))
		resource.load(new ByteArrayInputStream(input.getBytes), #{})
		val parsed = (resource.contents.get(0) as RegexModel)
		return parsed;		
	}
	
	def static ComplexEventProcessor compile(RegexModel input){
		val compiler = new RegexCompiler()
		return compiler.compile(input)
	}
	
	def static Event getEventByName(ComplexEventProcessor model, String name){
		val retvalue = EventAutomatonModelFactory.eINSTANCE.createEvent
		retvalue.type = model.symbolicEvents.findFirst[it.name.equals(name)]
		return retvalue
	}

	def static void test(String regex, String input){
		val model = regex.parse.compile
		val exec = new TestExecutioner(model)
		
		var processedInputs = 0
		var lastEvent = " "
		for(word : input.trim.split('\\s').map[it.trim].filter[!it.equals('')]){
			println('word = ' + word)
			if(word.startsWith('*')){
				val expressionName = word.substring(1)
				org.junit.Assert.assertEquals(
					("Assertion failed at input " + lastEvent + " #" + processedInputs + " on pattern " + expressionName) 
					,true
					,exec.acceptedLastTime(expressionName)
				)
			}else{
				exec.pushEvent(word)
				processedInputs++
				lastEvent = word
			}
		}
	}
	
	def static void foo(){
		var a = '''assda'''
		for(i : a.split('a')){
			
		}
	}
}

class TestExecutioner{
	public val CEPExecutioner exec
	public val ComplexEventProcessor model
	
	new(ComplexEventProcessor input){
		exec = new CEPExecutioner(input)
		model = input
	}
	
	def pushEvent(Event e){
		exec.pushEvent(e)
	}
	
	def pushEvent(String eventName){
		println('eventName = ' + eventName)
		val newEvent = EventAutomatonModelFactory.eINSTANCE.createEvent
		newEvent.type = model.symbolicEvents.findFirst[it.name.equals(eventName)]
		if(newEvent.type == null){
			throw new Exception('There is no such even '+eventName)
		}
		pushEvent(newEvent)
	}
	
	def acceptedLastTime(String name) {
		val expression = model.automata.findFirst[it.name.equals(name)]
		if(expression == null){
			//TODO throw exception or assertion failiure?
			return false
		}
		return expression.states.findFirst[it.acceptor && it.tokens.length > 0] != null
	}
	
}