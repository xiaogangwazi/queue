package Queue;
/*
消费者队列
 */
public class Consumer implements  Runnable{

    private  CycleQueue cycleQueue;
    private boolean running=true;
    public Consumer(CycleQueue cycleQueue){
        this.cycleQueue=cycleQueue;
    }

    @Override
    public void run() {

        int element = cycleQueue.element();
        while (running) {
            synchronized (cycleQueue) {
                if (cycleQueue.element() == 0) {
                    try {
                        cycleQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println(cycleQueue.dequeue() == 1 ? "取出成功" : "取出失败");
                }

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
