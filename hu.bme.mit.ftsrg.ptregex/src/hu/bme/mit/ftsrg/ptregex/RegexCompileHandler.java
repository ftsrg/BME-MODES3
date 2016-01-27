package hu.bme.mit.ftsrg.ptregex;

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

import hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel;
import hu.bme.mit.ftsrg.qea.CEPExecutioner;
import hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor;
import hu.bme.mit.ftsrg.qea.model.Event;
import hu.bme.mit.ftsrg.qea.model.ModelFactory;

public class RegexCompileHandler implements IHandler {

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
					RegexModel m = (RegexModel) res.getContents().get(0);
					RegexCompiler compiler = new RegexCompiler();
					ComplexEventProcessor result = compiler.compile(m);
					
					//TESTCODE
					
					
					System.out.println("TESTING");
					Event left =  ModelFactory.eINSTANCE.createEvent();
					left.setType(result.getSymbolicEvents().get(0));
					Event right =  ModelFactory.eINSTANCE.createEvent();
					right.setType(result.getSymbolicEvents().get(1));
					Event up =  ModelFactory.eINSTANCE.createEvent();
					up.setType(result.getSymbolicEvents().get(2));
					Event down =  ModelFactory.eINSTANCE.createEvent();
					down.setType(result.getSymbolicEvents().get(3));
					Event near=  ModelFactory.eINSTANCE.createEvent();
					near.setType(result.getSymbolicEvents().get(4));
					Event far =  ModelFactory.eINSTANCE.createEvent();
					far.setType(result.getSymbolicEvents().get(5));
					Event nearGround =  ModelFactory.eINSTANCE.createEvent();
					nearGround.setType(result.getSymbolicEvents().get(6));
					
					CEPExecutioner exec = new CEPExecutioner(result);

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