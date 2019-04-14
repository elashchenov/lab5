package labTasks.lab1;

import controllers.ConsoleController;

public class MoneyDoublingCounter {
    public static void calculate(final double initialMoneyAmount, final double annualInterest) {
        if (annualInterest <= 0 || initialMoneyAmount <= 0) {
            throw new IllegalArgumentException("program arguments must be positive numbers");
        }
        final double monthlyInterest = (Math.pow(1 + annualInterest / 100, 1d / 12) - 1);
        double finalMoneyAmount = initialMoneyAmount;
        int monthCount = 0;
        while ((initialMoneyAmount * 2) > finalMoneyAmount) {
            monthCount++;
            finalMoneyAmount += finalMoneyAmount * monthlyInterest;
        }
        ConsoleController.println("Years: " + monthCount / 12 + " Months: " + monthCount % 12);
    }
}
