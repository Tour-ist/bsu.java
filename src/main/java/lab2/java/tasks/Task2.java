package lab2.java.tasks;

public class Task2 extends AbstractTask {

    private double l;

    @Override
    protected void getParametersFromFile() {
        l = params.get(0);
    }

    @Override
    protected void getParametersFromKeyboard() {
        l = SCANNER.nextDouble();
    }

    @Override
    protected void calculate() {
        answer = 3.14 * Math.pow(l/(2 * 3.14), 2);
    }

    @Override
    protected boolean checkParameters() {
        return l > 0;
    }
}
