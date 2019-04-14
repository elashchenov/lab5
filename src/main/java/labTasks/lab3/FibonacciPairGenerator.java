package labTasks.lab3;

import controllers.ConsoleController;

public class FibonacciPairGenerator {
    private final Long[] fibonacciPair = {0L, 0L};
    private int numOfRepetitions;
    private int currRepetitionNumber;

    public void generate(int numOfRepetitions) {
        this.numOfRepetitions = numOfRepetitions;
        this.currRepetitionNumber = 0;
        new Thread(this::generateFibonacciPair).start();
        new Thread(this::printFibonacciPair).start();
    }

    private synchronized void generateFibonacciPair() {
        while (currRepetitionNumber < numOfRepetitions) {
            while ((fibonacciPair[0] != 0L) || (fibonacciPair[1] != 0L)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            fibonacciPair[0] = generateFibonacciNum();
            fibonacciPair[1] = generateFibonacciNum();
            notify();
        }
    }

    private long generateFibonacciNum() {
        final int finalFibonacciNumberOrdinal = (int) Math.round(Math.random() * 29);
        int currFibonacciNumberOrdinal = 1;
        long lastFibonacciNumber = 1L;
        long currFibonacciNumber = 1L;

        while (currFibonacciNumberOrdinal++ < finalFibonacciNumberOrdinal) {
            long fibonacciNum = currFibonacciNumber;
            currFibonacciNumber = currFibonacciNumber + lastFibonacciNumber;
            lastFibonacciNumber = fibonacciNum;
        }
        return currFibonacciNumber;
    }

    private synchronized void printFibonacciPair() {
        while (currRepetitionNumber++ < numOfRepetitions) {
            while ((fibonacciPair[0] == 0L) || (fibonacciPair[1] == 0L)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ConsoleController.println(
                    fibonacciPair[0] + " + " + fibonacciPair[1] + " = " + (fibonacciPair[0] + fibonacciPair[1])
            );
            fibonacciPair[0] = 0L;
            fibonacciPair[1] = 0L;
            notify();
        }
    }

}
