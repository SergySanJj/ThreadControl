package sample;

public class Decreaser implements Runnable {
    private SliderController sliderController;

    public Decreaser(SliderController sliderController) {
        this.sliderController = sliderController;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (sliderController.getSemaphore().compareAndSet(1, 0)) {
                    break;
                }
            }
            while (!Thread.currentThread().isInterrupted())
                sliderController.setSlider(10);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}