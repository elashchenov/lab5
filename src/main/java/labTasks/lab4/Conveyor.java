package labTasks.lab4;

public class Conveyor {
    private int numOfWorkers;
    private int numOfDetails;
    private final Detail[] details;

    public Conveyor(int numOfWorkers, int numOfDetails) {
        this.numOfWorkers = numOfWorkers;
        this.numOfDetails = numOfDetails;
        details = new Detail[numOfDetails];
    }

    public void run() {
        Worker[] workers = new Worker[numOfWorkers];

        for (int i = 0; i < numOfDetails; i++) {
            details[i] = new Detail("Detail" + (i + 1));
        }

        for (int i = 0; i < numOfWorkers; i++) {
            workers[i] = new Worker(i + 1, details);
            if (i > 0) {
                workers[i - 1].setNextWorker(workers[i]);
            }
        }

        for (Worker worker : workers) {
            worker.start();
        }

    }
}



