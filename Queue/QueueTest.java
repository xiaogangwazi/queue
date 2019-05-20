package Queue;


public class QueueTest {
    public static void main(String[] args) {
            ArrayQueue<String> queue = new ArrayQueue();
            queue.inqueue("1");
        queue.inqueue("2");
        queue.inqueue("3");
        queue.show();
        CycleQueue cycleQueue= new CycleQueue();
        cycleQueue.inqueue("1");
        cycleQueue.inqueue("2");
        cycleQueue.inqueue("3");
        cycleQueue.inqueue("4");
        cycleQueue.inqueue("5");
        cycleQueue.dequeue();
        cycleQueue.dequeue();
        cycleQueue.inqueue("6");
        cycleQueue.inqueue("7");
        cycleQueue.show();


    }

}
