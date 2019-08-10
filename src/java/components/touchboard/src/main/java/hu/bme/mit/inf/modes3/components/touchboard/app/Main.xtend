package hu.bme.mit.inf.modes3.components.touchboard.app

import hu.bme.mit.inf.modes3.components.touchboard.bridge.TouchboardBridge
import hu.bme.mit.inf.modes3.components.touchboard.controller.TouchboardController
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import java.io.IOException
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import org.slf4j.ILoggerFactory
import org.slf4j.impl.SimpleLoggerFactory

/**
 * The entry class of the touchboard application.
 * The application is able to supervise and control the model-railway track (trains, sections, turnouts) 
 * through a UI implemented in JavaFX.
 * 
 * @author hegyibalint
 */
class Main extends Application {

	static val FXML_PATH = "/views/main.fxml"
	static val STYLES_PATH = "/styles/style.css"

	static var ArgumentRegistry registry
	static var ILoggerFactory loggerFactory

	override void start(Stage primaryStage) throws IOException {
		val loader = new FXMLLoader(getClass().getResource(FXML_PATH))
		val controller = createController
		loader.controller = controller

		val pane = loader.load
		val scene = new Scene(pane, 650, 400)
		val css = getClass().getResource(STYLES_PATH).toExternalForm
		scene.getStylesheets().add(css)

		primaryStage.scene = scene
		primaryStage.fullScreen = true
		primaryStage.show

		controller.scene = scene
	}

	/**
	 * The application initializes and starts itself based on the command-line arguments.
	 * @param args command-line arguments
	 */
	def static void main(String[] args) {
		loggerFactory = new SimpleLoggerFactory
		registry = createArgumentRegistry(loggerFactory)
		registry.parseArguments(args)

		launch(args)
	}

	private def static createArgumentRegistry(ILoggerFactory loggerFactory) {
		val registry = new ArgumentRegistry(loggerFactory)
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("address", "The address of the transport server", String))
		registry.registerArgumentWithOptions(new ArgumentDescriptorWithParameter("port", "The port used by the transport server", Integer))
		return registry
	}

	private def static createController() {
		val topics = TopicFactory::createEveryTopicExcept("cv")
		val communicationStack = MessagingServiceFactory::createStackForTopics(registry, loggerFactory, topics)
		val controller = new TouchboardController(loggerFactory)
		val touchboardWrapper = new TouchboardBridge(controller, communicationStack, loggerFactory)
		return controller
	}
}
