package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class MainController {
    @FXML
    public Slider slider;

    @FXML
    public Button Start1;
    @FXML
    public Button Start2;


    @FXML
    public Button Stop1;
    @FXML
    public Button Stop2;


    private SliderController sliderController;
    private ThreadController threadController;
    private Thread updateThread;

    public MainController() {
        Platform.runLater(() -> {
            this.afterInit();
        });
    }

    @FXML
    public void afterInit() {
        sliderController = new SliderController(slider);
        threadController = new ThreadController(sliderController);
    }

    @FXML
    public void startThread1() {
        threadController.startThread1();
    }

    @FXML
    public void stopThread1() {
        threadController.stopThread1();

    }

    @FXML
    public void startThread2() {
        threadController.startThread2();
    }

    @FXML
    public void stopThread2() {
        threadController.stopThread2();

    }

}
