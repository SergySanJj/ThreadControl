package sample;

public class Increaser implements Runnable {
    private SliderController sliderController;

    public Increaser(SliderController sliderController) {
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
                sliderController.setSlider(90);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
