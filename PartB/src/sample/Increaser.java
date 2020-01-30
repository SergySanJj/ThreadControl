package sample;

public class Increaser implements Runnable {
    private SliderController sliderController;

    public Increaser(SliderController sliderController) {
        this.sliderController = sliderController;
    }

    @Override
    public void run() {
        try {

            sliderController.setSlider(90);

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
