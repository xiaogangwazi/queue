package Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CycleQueue cycleQueue = new CycleQueue();
        Consumer consumer = new Consumer(cycleQueue);
        Producter producter = new Producter(cycleQueue);
        Thread thread = new Thread(consumer,"thread1");
        Thread thread1 = new Thread(producter,"thread2");
        thread1.start();
        thread.start();

    }

}
