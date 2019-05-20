package Queue;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Producter  implements  Runnable {
    private CycleQueue cycleQueue;
    public Producter(CycleQueue cycleQueue){
        this.cycleQueue=cycleQueue;
    }
    @Override
    public void run() {
        int element = cycleQueue.element();
        int i=0;
        while(true){
            try {
               Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (cycleQueue){
                if(cycleQueue.element()==1){
                   System.out.println("满了");
                }else{
                    int inqueue = cycleQueue.inqueue(i + "");

                    System.out.println(inqueue==1?"添加成功":"添加失败");
                    cycleQueue.notifyAll();
                }
                i++;
            }
        }
    }

}
