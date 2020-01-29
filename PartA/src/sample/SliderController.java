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
    }


    public void incSlider() {

        int newVal = rangeChecker((int) slider.getValue() + 1);
        slider.setValue(newVal);
        label.setText(Integer.toString(newVal));

    }

    public void decSlider() {

        int newVal = rangeChecker((int) slider.getValue() - 1);
        slider.setValue(newVal);
        label.setText(Integer.toString(newVal));


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
