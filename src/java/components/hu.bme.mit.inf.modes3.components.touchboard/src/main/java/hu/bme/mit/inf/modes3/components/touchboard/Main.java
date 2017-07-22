package hu.bme.mit.inf.modes3.components.touchboard;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hu/bme/mit/inf/modes3/components/touchboard/views/main.fxml"));
        Pane pane = loader.load();
        Scene scene = new Scene(pane, 650, 400);
        
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
