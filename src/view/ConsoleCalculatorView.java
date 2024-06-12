package view;

public class ConsoleCalculatorView implements CalculatorView {
    @Override
    public void displayResult(String result) {
        System.out.println("Result: " + result);
    }

    @Override
    public void showError(String message) {
        System.err.println("Error: " + message);
    }
}
