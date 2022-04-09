package lab4;

import java.util.Random;

/**
 * Метод останавливает выполнение потока на случайное время в предехал 3сек.
 */
public class Utils {
    public static void delay() {
        long delay;
        Random rnd = new Random();
        delay = 1000 + rnd.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
