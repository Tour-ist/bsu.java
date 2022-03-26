package lab2.java.lab;

import org.apache.log4j.BasicConfigurator;
import lab2.java.tasks.*;

public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        var task1 = new Task1();
        var task2 = new Task2();
        var task3 = new Task3();
        var task4 = new Task4();
        var task5 = new Task5();
        var task6 = new Task6();
        var task7 = new Task7();
        var task8 = new Task8();
        task1.execute("File");
        task2.execute("File");
        task3.execute("File");
        task4.execute("File");
        task5.execute("File");
        task6.execute("File");
        task7.execute("File");
        task8.execute("File");

    }
}
