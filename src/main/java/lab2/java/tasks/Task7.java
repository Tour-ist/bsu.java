package lab2.java.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task7 extends AbstractTask {

    private List<Double> numbers;

    @Override
    protected void getParametersFromFile() {
        numbers = params;
    }

    @Override
    protected void getParametersFromKeyboard() {
        int numberCount = SCANNER.nextInt();
        var list = new ArrayList<Double>();
        for (int i = 0; i < numberCount; i++) {
            list.add(SCANNER.nextDouble());
        }
        numbers = list;
    }

    @Override
    protected void calculate() {
        String arithmeticMeanRecords = "";
        double arithmeticMean = 0;
        int count = 0;
        while(!params.isEmpty()) {
            arithmeticMean += params.get(0);
            arithmeticMean /= count;
            arithmeticMeanRecords = arithmeticMeanRecords.concat(" " + arithmeticMean);
            count++;
            params.remove(0);
        }
        answer = arithmeticMeanRecords;
    }

    @Override
    protected boolean checkParameters() {
        return true;
    }
}
