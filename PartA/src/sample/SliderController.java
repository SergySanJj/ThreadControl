package sample;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SliderController {
    private int minValue = 10;
    private int maxValue = 90;
    private Integer currVal = 50;
    private Slider slider;
    private Label label;

    public SliderController(Slider slider, Label label) {
        this.slider = slider;
        this.label = label;
        label.setLabelFor(slider);
    }


    public void incSlider() {
        synchronized (slider) {
            currVal = rangeChecker(currVal + 1);
            slider.setValue(currVal);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void decSlider() {
        synchronized (slider) {
            currVal = rangeChecker(currVal - 1);
            slider.setValue(currVal);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
