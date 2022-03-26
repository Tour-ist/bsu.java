package lab2.java.tasks;

public class Task1 extends AbstractTask {

    private double x;
    private double y;

    @Override
    protected void getParametersFromFile() {
        x = params.get(0);
        y = params.get(1);
    }

    @Override
    protected void getParametersFromKeyboard() {
        x = SCANNER.nextDouble();
        y = SCANNER.nextDouble();
    }

    @Override
    protected void calculate() {
        answer = Math.pow(1 + Math.pow(x, -2), x) - 12 * Math.pow(x, 2) * y;
    }

    @Override
    protected boolean checkParameters() {
        return true;
    }
}
