package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainController {
    @FXML
    public Label label;

    @FXML
    public Slider slider;

    @FXML
    public Button startButton;

    private SliderController sliderController;
    private ThreadController threadController;
    private Thread updateThread;

    public MainController() {

    }

    @FXML
    public void startThreads() {
        this.startButton.setDisable(true);
        sliderController = new SliderController(slider, label);
        threadController = new ThreadController(sliderController);
        updateThread = new Thread(threadController);

        updateThread.start();
    }

    @FXML
    public void t1Inc(Event event) {
        threadController.changePriority(1, 1);
    }

    @FXML
    public void t1Dec(Event event) {
        threadController.changePriority(1, -1);

    }

    @FXML
    public void t2Inc(Event event) {
        threadController.changePriority(2, 1);

    }

    @FXML
    public void t2Dec(Event event) {
        threadController.changePriority(2, -1);

    }

}
