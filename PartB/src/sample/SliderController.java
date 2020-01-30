package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SliderController {
    private volatile int semaphore = 1; // 0 - block, non-zero - unblock
    private int minValue = 10;
    private int maxValue = 90;
    private Integer currVal = 50;
    private Slider slider;


    public int getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(int val) {
        semaphore = val;
        System.out.println("Semaphore val " + semaphore);
    }

    public SliderController(Slider slider) {
        this.slider = slider;
        Platform.runLater(() -> {
            slider.setValue(currVal);
        });

    }


    public void setSlider(int val) {
        currVal = rangeChecker(val);
        Platform.runLater(() -> {
            slider.setValue(currVal);
        });
    }


    private int rangeChecker(int val) {
        if (val < minValue) {
            return minValue;
        } else if (val > maxValue) {
            return maxValue;
        }
        return val;
    }

}
