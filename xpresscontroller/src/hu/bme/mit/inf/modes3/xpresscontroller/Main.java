package hu.bme.mit.inf.modes3.xpresscontroller;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		PropertyConfigurator.configure("log4j.properties");
		
		Controller c = new Controller();
		c.init();
	}

}
