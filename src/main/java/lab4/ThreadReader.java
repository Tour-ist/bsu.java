package lab4;

/**
 * Поток-"чиаттель", осуществляющий чтение сообщений из буфера
 */
final class ThreadReader implements Runnable {
    private volatile long lastReadTimestamp = 0L;
    private long timeout;

    public ThreadReader(long timeout) {
        this.timeout = timeout;
    }

    public void run(){
        lastReadTimestamp = System.currentTimeMillis();
        while (System.currentTimeMillis() - lastReadTimestamp < timeout){
            Utils.delay();
            SData.lrw.lock();
            try {
                if(!SData.buffer.isEmpty()){
                    String line = SData.buffer;
                    System.out.println("Читатель - " + Thread.currentThread().getName() + " читает строку: " + line);
                    SData.buffer = "";
                    lastReadTimestamp = System.currentTimeMillis();
                }
            } finally {
                SData.lrw.unlock();
            }
        }
    }
}