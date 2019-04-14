package labTasks.lab4;

import controllers.ConsoleController;
import lombok.Setter;

class Worker extends Thread {
    private int ordinalNumber;
    private Detail[] details;
    @Setter
    private Worker nextWorker = null;

    Worker(int ordinalNumber, Detail[] details) {
        super("Worker" + ordinalNumber);
        this.ordinalNumber = ordinalNumber;
        this.details = details;
    }

    @Override
    public void run() {
        for (Detail detail : details) {
            synchronized (this) {
                while (detail.getPhase() != ordinalNumber) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ConsoleController.println(Thread.currentThread().getName() + " - " + detail.getName());
                detail.incrementPhase();
                if (nextWorker != null) {
                    //noinspection SynchronizeOnNonFinalField
                    synchronized (nextWorker) {
                        nextWorker.notify();
                    }
                }
            }
        }

    }
}