package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        if (primaryScreenBounds.getWidth() == 1280 && primaryScreenBounds.getHeight() == 1024)
            primaryStage.setFullScreen(true);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/start_near_highdefinition.fxml"));
        primaryStage.setTitle("VRR_Monitor");



        Scene scene = new Scene(root);
        scene.setOnKeyPressed((KeyEvent event) -> handleExit(event));

        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();

        root.setFocusTraversable(true);
        root.requestFocus();
    }

    public void handleExit(KeyEvent event) {
        KeyCombination ctrlC = new KeyCodeCombination(KeyCode.C, KeyCodeCombination.CONTROL_ANY);
        if (ctrlC.match(event)) System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
