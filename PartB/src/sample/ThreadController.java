package sample;

public class ThreadController {

    private Thread t1, t2;
    private SliderController sliderController;

    private volatile boolean isRunning1;
    private volatile boolean isRunning2;

    public ThreadController(SliderController sliderController) {
        this.sliderController = sliderController;
    }

    public void startThread1() {
        if (sliderController.getSemaphore().get() == 0) {
            System.out.println("Critical region is blocked");
            return;
        }
        sliderController.setSemaphore(0);
        isRunning1 = true;
        t1 = new Thread(new Increaser(this.sliderController));
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }

    public void stopThread1() {
        if (!isRunning1)
            return;
        t1.interrupt();
        sliderController.setSemaphore(1);
        isRunning1 = false;
    }

    public void startThread2() {
        if (sliderController.getSemaphore().get() == 0) {
            System.out.println("Critical region is blocked");
            return;
        }
        sliderController.setSemaphore(0);
        isRunning2 = true;
        t2 = new Thread(new Decreaser(this.sliderController));
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
    }

    public void stopThread2() {
        if (!isRunning2)
            return;
        t2.interrupt();
        sliderController.setSemaphore(1);
        isRunning2 = false;
    }


    public void changePriority(int threadNum, int change) {
        Thread t = getThread(threadNum);
        if (t == null)
            return;
        int newPriority = rangePriority(t.getPriority() + change);
        t.setPriority(newPriority);
        System.out.println("Set priority of thread " + threadNum + " to " + newPriority);
    }

    private void setPriority(int threadNum, int newPriority) {
        getThread(threadNum).setPriority(newPriority);
    }

    private Thread getThread(int n) {
        if (n == 1)
            return t1;
        else return t2;
    }

    private int rangePriority(int val) {
        if (val > Thread.MAX_PRIORITY)
            return 10;
        else if (val < Thread.MIN_PRIORITY)
            return 1;
        return val;
    }
}
