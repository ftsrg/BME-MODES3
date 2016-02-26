package hu.bme.mit.inf.vepl2ptregex.ui;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.viatra.cep.vepl.vepl.EventModel;

import EventAutomatonModel.ComplexEventProcessor;
import EventAutomatonModel.Event;
import EventAutomatonModel.EventAutomatonModelFactory;
import hu.bme.mit.inf.parametricTimedRegularExpression.RegexModel;
import hu.bme.mit.inf.ptregex2automaton.RegexCompiler;
import hu.bme.mit.inf.ptregex2automaton.RegexPrinter;
import hu.bme.mit.inf.qea.CEPExecutor;
import hu.bme.mit.inf.vepl2ptregex.VeplCompiler;

public class VeplCompileHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {

			Object _element = ((IStructuredSelection) currentSelection)
					.getFirstElement();
			if (_element instanceof IFile) {
				IFile selectedFile = (IFile) _element;
				ResourceSet set = new ResourceSetImpl();

				Resource res = set.getResource(URI.createPlatformResourceURI(
						selectedFile.getFullPath().toString(), true), true);
				try {
					// =========================== Model manipulation ===========================
					
					
					
					EventModel eventModel = (EventModel) res.getContents().get(0);
					VeplCompiler veplCompiler = new VeplCompiler();
					RegexModel regexModel = veplCompiler.compile(eventModel);
					
					System.out.println("Regex patterns : ");
					System.out.println(RegexPrinter.regexToString(regexModel));
					
					RegexCompiler regexCompiler = new RegexCompiler();
					ComplexEventProcessor result = regexCompiler.compile(regexModel);
					
					
					
					//TESTCODE
					
					
					System.out.println("TESTING");
					Event left =  EventAutomatonModelFactory.eINSTANCE.createEvent();
					left.setType(result.getSymbolicEvents().get(0));
					Event right =  EventAutomatonModelFactory.eINSTANCE.createEvent();
					right.setType(result.getSymbolicEvents().get(1));
					Event up =  EventAutomatonModelFactory.eINSTANCE.createEvent();
					up.setType(result.getSymbolicEvents().get(2));
					Event down =  EventAutomatonModelFactory.eINSTANCE.createEvent();
					down.setType(result.getSymbolicEvents().get(3));
					Event near=  EventAutomatonModelFactory.eINSTANCE.createEvent();
					near.setType(result.getSymbolicEvents().get(4));
					Event far =  EventAutomatonModelFactory.eINSTANCE.createEvent();
					far.setType(result.getSymbolicEvents().get(5));
					Event nearGround =  EventAutomatonModelFactory.eINSTANCE.createEvent();
					nearGround.setType(result.getSymbolicEvents().get(6));
					
					CEPExecutor exec = new CEPExecutor(result);

					exec.pushEvent(right);
					exec.pushEvent(down);
					exec.pushEvent(left);
					exec.pushEvent(near);
					exec.pushEvent(up);
					exec.pushEvent(far);
					exec.pushEvent(down);
					exec.pushEvent(nearGround);
					exec.pushEvent(up);
					
					System.out.println("END OF TESTING");
					
				} catch (Throwable e) {
					System.out.println(e);
					e.printStackTrace();
					throw new ExecutionException(e.getMessage(), e);
				} finally{
				}
			}
		}
		return null;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

}