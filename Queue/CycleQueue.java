package Queue;

public class CycleQueue {

        private String[] queue;
        private int size;//队列最大容量
        private int head;//队首下标
        private int tail;//下一个要插入元素的下标
        private int count;//队列元素数量
        private static final int DEFAULTSIZE = 4;


        public CycleQueue() {
            queue = new String[DEFAULTSIZE];
            head = 0;
            tail = 0;
            count = 0;
            size = DEFAULTSIZE;
        }

        public int inqueue(String value) {
            if (count < size) {//没有满
                if (tail == head && tail == 0) {//首次插入
                    queue[tail++] = value;
                } else if (tail == size - 1) {//队尾元素已经到队列尾部
                    queue[tail] = value;
                    tail = 0;

                } else if (tail > head) {//队尾还没有到达队列尾部
                    queue[tail++] = value;

                } else if (tail < head) {//循环队列的队尾已经到达队首前面位置
                    queue[tail++] = value;
                }
                count++;
                return 1;
            } else {
                System.out.println("队列已经满了");
                return 0;
            }

        }

        public int dequeue() {
            if (count > 0) {//有元素
                if (head == size - 1) {//对头元素到达尾部
                    head = 0;
                    count--;
                } else {
                    head++;
                    count--;
                }
                return 1;
            }
            return 0;
        }

        public void show() {
            int sum = count;
            int hea = head;
            int tai = tail;
            while (sum > 0 && hea != tai - 1) {
                System.out.println(queue[hea]);
                if (hea == size - 1) {
                    hea = 0;
                } else {
                    hea++;
                }
                sum--;
            }
            System.out.println(queue[hea]);

        }

        public int element() {
            if (count == size && count != 0) {//满了
                return 1;
            } else if ( count == 0) {//为空
                return 0;
            }
            return 2;
        }



}
