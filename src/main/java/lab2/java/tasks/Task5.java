package lab2.java.tasks;

public class Task5 extends AbstractTask {

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
        switch(n) {
            case 1 -> answer = "Зима; Декабрь 31, Январь 31, Февраль 28";
            case 2 -> answer = "Весна; Март 31, Апрель 30, Май 31";
            case 3 -> answer = "Лето; Июнь 30, Июль 31, Август 30";
            case 4 -> answer = "Осень; Сентябрь 31, Октябрь 30, Ноябрь 31";
        }
    }

    @Override
    protected boolean checkParameters() {
        return n == 1 || n == 2 || n == 3 || n == 4;
    }
}
