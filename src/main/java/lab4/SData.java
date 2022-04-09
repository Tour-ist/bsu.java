package lab4;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 10.	Несколько потоков работают с общим одноэлементным буфером.
 * Потоки делятся на "писателей" и "читателей".Только 1 поток может осуществлять работу с буфером.
 * Если буфер свободен, то только 1 писатель может осуществлять запись в буфер.
 * Если буфер занят, то только один читатель может осуществлять чтение из буфера.
 * После чтения буфер освобождается и доступен для записи.
 * В качестве буфера используется глобальная переменная buffer.
 * Работа приложения заканчивается после того, как все сообщения писателей через общий буфер будут обработаны читателями.
 */
final class SData {
    public static String buffer  = "";
    public static final ReentrantLock lrw = new ReentrantLock();
    private static final int READERS_COUNT = 2;
    private static final int TIMEOUT = 5000;
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        executorService.submit(new ThreadWriter("a\r\nb\r\nc\r\n"));
        executorService.submit(new ThreadWriter("1\r\n2\r\n3\r\n"));
        for (int i = 0; i < READERS_COUNT; i++) {
            executorService.submit(new ThreadReader(TIMEOUT));
        }
        executorService.shutdown();
    }
}