package hu.bme.mit.inf.xpresscontroller;

import org.junit.Test;

public class ControllerTest {
	
	@Test
	public void test() throws InterruptedException {
		
		
		Controller controller = new Controller();
		controller.init();
		
		for (Turnout t : Turnout.values()) {
			controller.setTurnout(t, true);
		}
		
		Thread.sleep(5000);
		
		for (Turnout t : Turnout.values()) {
			controller.setTurnout(t, false);
		}
		
		Thread.sleep(5000);
	}
}
