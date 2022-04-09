package lab4;

/**
 * Поток-"писатель", осуществляющий запись сообщений в буфер
 */
final class ThreadWriter implements Runnable {
    private String text;
    public ThreadWriter(String text) {
        this.text = text;
    }
    public void run() {

        String[] messages = text.split("\\r?\\n");
        for (String message : messages){
            Utils.delay();
            SData.lrw.lock();
            try {
                if(SData.buffer.isEmpty()){
                    System.out.println("\tПОДОЖДИТЕ, ПИСАТЕЛЬ - " + Thread.currentThread().getName() + ", ПИШЕТ: " + message);
                    SData.buffer = SData.buffer.concat(message + "\r\n");
                    Utils.delay();}
            }  finally {
                SData.lrw.unlock();
            }
        }
    }
}
