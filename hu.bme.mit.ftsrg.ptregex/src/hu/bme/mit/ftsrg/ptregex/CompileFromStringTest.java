package hu.bme.mit.ftsrg.ptregex;

import org.junit.Test;

import hu.bme.mit.ftsrg.qea.AutomatonExecutioner;
import hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor;
import hu.bme.mit.ftsrg.qea.model.Event;
import hu.bme.mit.ftsrg.qea.model.ModelFactory;

public class CompileFromStringTest {

	@Test
	public void test() {
		System.out.println("Starting the compile test process");
		try{
			String input = "alphabet = {A, B, C} expression exprChoice = A | B ";
			RegexCompiler compiler = new RegexCompiler();
			ComplexEventProcessor result = compiler.expressionToTGF(input); // a Complex Event Processornak vannak automatai, ha esetleg kodbol el szeretned erni.
			AutomatonExecutioner exec = new AutomatonExecutioner(result.getAutomata().get(0));
			
			Event a = ModelFactory.eINSTANCE.createEvent();
			a.setType(result.getSymbolicEvents().get(0));

			Event b = ModelFactory.eINSTANCE.createEvent();
			b.setType(result.getSymbolicEvents().get(1));
			
			
			System.out.println('1');
			exec.pushEvent(a);

			System.out.println('2');
			exec.pushEvent(b);


			System.out.println('3');
			exec.pushEvent(a);

			
			System.out.println("Done");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
