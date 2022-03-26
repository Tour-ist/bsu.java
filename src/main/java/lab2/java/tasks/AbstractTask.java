package lab2.java.tasks;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractTask {

    private static final Logger LOGGER = Logger.getLogger(AbstractTask.class);
    protected static final Scanner SCANNER = new Scanner(System.in);
    protected Object answer;
    protected List<Double> params;

    /**
     * Этот метод логирует результат, хранящийся в {@code answer}.
     * */
    protected void logResult() {
        LOGGER.info("The answer of " + getClass().getName() + " is " + answer);
    }

    /**
     * Этот метод логирует ошибку, если параметры были неправильными.
     * */
    protected void logParamError() {
        LOGGER.error("There is a mistake in parameters!");
    }

    /**
     * Здесь происходит считывание параметров из файла. Имя файла совпадает
     * с полным названием класса
     * */
    private void readParamFile() {
        var inputList = new ArrayList<Double>();
        try (FileReader fileReader = new FileReader("./src/main/resources/" + getClass().getName() + ".txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            while (bufferedReader.ready()) {
                inputList.add(Double.parseDouble(bufferedReader.readLine()));
            }
            params = inputList;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Could not read data from file!");
        }
    }

    /**
     * Этот метод считывает параметры из файла и помещает
     * их в список {@code params}. После этого параметры готовы
     * к использованию в задании.
     * */
    protected void extractParameters() {
        readParamFile();
        getParametersFromFile();
    }

    protected abstract void getParametersFromFile();

    protected abstract void getParametersFromKeyboard();


    /**
     * Этот метод выполняет задание,
     * помещает ответ в объект {@code answer}, и логирует его.
     * */
    protected void getAnswer() {
        calculate();
        logResult();
    }

    protected abstract void calculate();

    /**
     * Этот метод проверяет входные параметры.
     * Для проверки необходимо только условие, по которому отбираются параметры,
     * например {@code x > 0 && y > 0}.
     * @return булево значение, исходя из которого решается, будет получен ответ или будет записана ошибка
     * */
    protected abstract boolean checkParameters();

    /**
     * Этот метод является главным и выполняет всю логику задания.
     * @param inputType В зависимости от значения этого параметра производится считывание их из файла или с клавиатуры
     * В зависимости от результата выполнения метода {@code checkParameters()} логируется ошибка или результат
     * */
    public void execute(String inputType) {
        if(inputType.equals("File")) {
            extractParameters();
        } else if(inputType.equals("Keyboard")) {
            getParametersFromKeyboard();
        }
        if(checkParameters()) {
            getAnswer();
        } else {
            logParamError();
        }
    }
}
