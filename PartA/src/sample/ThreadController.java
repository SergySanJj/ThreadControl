package sample;

public class ThreadController implements Runnable {
    private Thread t1, t2;
    private SliderController sliderController;

    public ThreadController(SliderController sliderController) {
        this.sliderController = sliderController;
        t1 = new Thread(new Increaser(this.sliderController));
        t2 = new Thread(new Decreaser(this.sliderController));
    }

    @Override
    public void run() {
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
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
