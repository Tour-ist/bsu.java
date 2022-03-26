package lab2.java.tasks;

public class Task4 extends AbstractTask {

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
        answer = (a + b > 0 || a + c > 0 || b + c > 0);
    }

    @Override
    protected boolean checkParameters() {
        return true;
    }
}
