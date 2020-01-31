package sample;

public class Increaser implements Runnable {
    private SliderController sliderController;

    public Increaser(SliderController sliderController) {
        this.sliderController = sliderController;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                sliderController.incSlider();
            }
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
