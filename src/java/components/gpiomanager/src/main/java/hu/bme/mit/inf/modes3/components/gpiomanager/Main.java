/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.util.ArrayList;

/**
 * The entry class of the GPIO Manager application.
 * The application is responsible for managing the GPIO port (of the Beagle Bone Black microcontrollers) from Java.  
 * 
 * @author zsoltmazlo
 */
public class Main {

	/**
	 * The application initializes and starts itself based on the command-line arguments.
	 * 
	 * @param args the command line arguments
	 * @throws Exception {@link #checkSegmentActuator2()}, {@link #checkInput()}
	 */
    public static void main(String[] args) throws Exception {

        GpioManager.loadGpioMappingFromFile(args[0]);

        checkSegmentActuator2();

        checkInput();

        GpioManager.cleanup();

    }

    /**
     * Tests the segment actuators with a given impulse length.
     * 
     * @throws Exception {@link GpioManager#setGpio(String, hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Direction)}, 
     * {@link Gpio#setLevel(hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level)}, {@link Thread#sleep(long)}
     */
    public static void checkSegmentActuator() throws Exception {
        // running test with P6-G6 and P7-G7
        ArrayList<Gpio> gpios = new ArrayList<>();
        gpios.add(GpioManager.setGpio("P6", Gpio.Direction.OUT));
        gpios.add(GpioManager.setGpio("P7", Gpio.Direction.OUT));
        gpios.add(GpioManager.setGpio("G6", Gpio.Direction.OUT));
        gpios.add(GpioManager.setGpio("G7", Gpio.Direction.OUT));

        // test will be the following: every 500s one gpio set to high, and then the set to low
        for (Gpio g : gpios) {
            g.setLevel(Gpio.Level.HIGH);
            Thread.sleep(500);
        }

        for (Gpio g : gpios) {
            g.setLevel(Gpio.Level.LOW);
            Thread.sleep(500);
        }

    }

    /**
     * Tests the segment actuators with a given impulse length.
     * 
     * @throws Exception {@link GpioManager#setGpio(String, hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Direction)}, 
     * {@link Gpio#setLevel(hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level)}, {@link Thread#sleep(long)}
     */
    public static void checkSegmentActuator2() throws Exception {
        // running test with P6-G6 and P7-G7
        ArrayList<Gpio> gpios = new ArrayList<>();
        gpios.add(GpioManager.setGpio("P6", Gpio.Direction.OUT));
        gpios.add(GpioManager.setGpio("G6", Gpio.Direction.OUT));

        // test will be the following: every 500s one gpio set to high, and then the set to low
        int impulseWidth = 4000;
        for (Gpio g : gpios) {
            g.impulse(impulseWidth, true);
            impulseWidth -= 500;
        }

    }

    /**
     * A listener to test the level changes of GPIO ports with.
     * 
     * @author zsoltmazlo
     */
    private static class TestListener implements Gpio.InputStateListener {

        private static final String TAG = "LISTENER";
        private final Gpio p7;
        private final Gpio g7;

        /**
         * @throws Exception {@link GpioManager#setGpio(String, hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Direction)}
         */
        public TestListener() throws Exception {
            p7 = GpioManager.setGpio("P7", Gpio.Direction.OUT);
            g7 = GpioManager.setGpio("G7", Gpio.Direction.OUT);
        }

        @Override
        public void levelStateChanged(Gpio.Level newLevel) {
            Logger.info(TAG, "level changed! %s", newLevel.toString());

            try {
                p7.setLevel(newLevel);
                g7.setLevel(newLevel);
            } catch (Exception e) {
                Logger.info(TAG, "P7 or G7 could not be setted to right level!");
            }
        }

    }

    /**
     * To test a GPIO port with INPUT direction.
     * 
     * @throws Exception {@link GpioManager#setGpio(String, hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Direction)}, 
     * {@link TestListener#TestListener()}
     */
    public static void checkInput() throws Exception {

        Gpio g = GpioManager.setGpio("P0", Gpio.Direction.IN);
        g.addInputStateListener(new TestListener());

        // wait for one key
        System.console().format("Press ENTER to proceed.\n");
        System.console().readLine();
    }

}
