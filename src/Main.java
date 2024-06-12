import controller.CalculatorPresenter;
import data.*;
import view.CalculatorView;
import view.ConsoleCalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorView view = new ConsoleCalculatorView();
        CalculatorPresenter presenter = new CalculatorPresenter(view);

        ComplexNumber num1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber num2 = new ComplexNumber(3.0, 4.0);

        presenter.performOperation(num1, num2, new Addition());
        presenter.performOperation(num1, num2, new Subtraction());
        presenter.performOperation(num1, num2, new Multiplication());
        presenter.performOperation(num1, num2, new Division());
    }
}