package sample;

import javafx.application.Platform;
import javafx.scene.control.Slider;

import java.util.concurrent.atomic.AtomicInteger;

public class SliderController {
    private AtomicInteger semaphore = new AtomicInteger(1); // 0 - block, non-zero - unblock
    private int minValue = 10;
    private int maxValue = 90;
    private Integer currVal = 50;
    private Slider slider;


    public AtomicInteger getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(int val) {
        semaphore.set(val);
        System.out.println("Semaphore val " + semaphore.get());
    }

    public SliderController(Slider slider) {
        this.slider = slider;
        Platform.runLater(() -> {
            slider.setValue(currVal);
        });

    }


    public void setSlider(int val) {
        currVal = rangeChecker(val);
        slider.setValue(currVal);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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
