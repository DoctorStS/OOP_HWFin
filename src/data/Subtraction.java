package data;

public class Subtraction implements ComplexOperation {
    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getReal() - b.getReal(), a.getImaginary() - b.getImaginary());
    }

    @Override
    public String getName() {
        return "Subtraction";
    }
}
