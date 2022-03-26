package lab2.java.tasks;

public class Task6 extends AbstractTask {

    private int n;
    private int m;

    @Override
    protected void getParametersFromFile() {
        n = (int)(double)params.get(0);
        m = (int)(double)params.get(1);
    }

    @Override
    protected void getParametersFromKeyboard() {
        n = SCANNER.nextInt();
        m = SCANNER.nextInt();
    }

    @Override
    protected void calculate() {
        int count = 0;
        int countPrevious = 0;
        int max = n;
        for (int i = n; i <= m; i++) {
            for(int j = 1; j <= i; j++){
                if ((i % j) == 0){
                    count++;
                }
            }
            if(countPrevious < count) {
                max = i;
            }
            countPrevious = count;
            count = 0;
        }
        answer = max;
    }

    @Override
    protected boolean checkParameters() {
        return n < m;
    }
}
