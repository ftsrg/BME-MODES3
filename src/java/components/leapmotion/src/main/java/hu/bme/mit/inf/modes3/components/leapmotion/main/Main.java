package hu.bme.mit.inf.modes3.components.leapmotion.main;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.slf4j.impl.SimpleLoggerFactory;

import hu.bme.mit.inf.modes3.components.leapmotion.LeapMotionBridge;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry;

/**
 * The entry point of the Leap Motion application.
 * The translates the human motions for train commands. The motions are detected by a third-party device. 
 * 
 * @author benedekh
 */
public class Main {
	
    private static SimpleLoggerFactory loggerFactory;
	
    private static ArgumentRegistry registry;
    
    private static Executor executor;
    
	/**
	 * The application initializes and starts itself based on the command-line arguments.
	 * 
	 * @param args the command line arguments
	 * @throws Exception {@link #checkSegmentActuator2()}, {@link #checkInput()}
	 */
	public static void main(String[] args) {
		loggerFactory = new SimpleLoggerFactory();
		registry = new ArgumentRegistry(loggerFactory);
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The ID of the component", String.class));
        registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("id", "The ID of the component", String.class));
        registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("pubPort", "The ID of the component", Integer.class));
        registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("repPort", "The ID of the component", Integer.class));
        registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("config", "The ID of the component", String.class));
        registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("leaphost", "The host ip of the leap motion gesture stream", String.class));
        
        registry.parseArguments(args);
        
        executor = Executors.newCachedThreadPool();
        
        LeapMotionBridge bridge = new LeapMotionBridge(registry, loggerFactory);
        executor.execute(bridge);
	}
	
}
