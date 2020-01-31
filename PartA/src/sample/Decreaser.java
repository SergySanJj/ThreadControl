package sample;

public class Decreaser implements Runnable {
    private SliderController sliderController;

    public Decreaser(SliderController sliderController) {
        this.sliderController = sliderController;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                sliderController.decSlider();
            }
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}