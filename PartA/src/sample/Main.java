package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.lang.management.ManagementFactory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Thread control");
        primaryStage.setScene(new Scene(root, 800, 600));

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

        primaryStage.show();

    }



    public static void main(String[] args) {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        launch(args);
    }
}
