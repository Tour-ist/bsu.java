package lab2.java.tasks;

public class Task3 extends AbstractTask {

    private double a;
    private double b;
    private double c;

    @Override
    protected void getParametersFromFile() {
        a = params.get(0);
        b = params.get(1);
        c = params.get(2);
    }

    @Override
    protected void getParametersFromKeyboard() {
        a = SCANNER.nextDouble();
        b = SCANNER.nextDouble();
        c = SCANNER.nextDouble();
    }

    @Override
    protected void calculate() {
        answer = (a == b && a == c);
    }

    @Override
    protected boolean checkParameters() {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }
}
