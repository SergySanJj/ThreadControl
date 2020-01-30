package sample;

public class Decreaser implements Runnable {
    private SliderController sliderController;

    public Decreaser(SliderController sliderController) {
        this.sliderController = sliderController;
    }

    @Override
    public void run() {
        try {

            sliderController.setSlider(10);

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}