package lab2.java.tasks;

public class Task8 extends AbstractTask {

    private int n;

    @Override
    protected void getParametersFromFile() {
        n = (int)(double)params.get(0);
    }

    @Override
    protected void getParametersFromKeyboard() {
        n = SCANNER.nextInt();
    }

    @Override
    protected void calculate() {
        double P = 0;
        for (int i = 2; i < n; i++) {
            P -= (1 - Math.pow(i, -i));
        }
        P += 2 * (1 - Math.pow(2, -2));
        answer = P;
    }

    @Override
    protected boolean checkParameters() {
        return n > 2;
    }
}