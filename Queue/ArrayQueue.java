package Queue;

import java.util.ArrayList;

public class ArrayQueue<T> {
        private Object[] queue;//队列数组
        private int n;//队列的大小
        private int count;//队列的元素个数
        private int head;//指向队头元素的下标
        private int end;//指向要队尾要插入的元素下标
        private final  int DEFAULT_SIZE=16;
        public ArrayQueue(int n){
            this.n=n;
            queue= new Object[n] ;
            count=0;
            head=0;
            end=0;
        }
        public ArrayQueue(){
            this.n=DEFAULT_SIZE;
            queue= new String[n] ;
            count=0;
            head=0;
            end=0;
        }

        public int dequeue(){//出队列操作
            if(head==end){
                return 0;
            }
            head++;
            count--;
            return 1;

        }
        public int inqueue(Object value){
            if(end>=n){//队尾到达数组最大下标值
                if (head>0){//数组还存在没有利用的空间
                    for(int i=head;i<end;i++){
                        queue[i-head]=queue[i];
                        head=0;
                        end=end-head;
                        queue[end++]= (Object) value;
                        count++;
                    }
                    return 1;
                }else if(head==0){
                    throw new IndexOutOfBoundsException("队列内存已满");
                }
                return 0;
            }else {
                queue[end++] = (Object) value;
                count++;
                return 1;
            }
        }


        public void show() {
            StringBuffer stringBuffer = new StringBuffer();
            for(Integer i=head;i<end;i++){
                StringBuffer stringBuffer1 = new StringBuffer(queue[i]+"<--");
                stringBuffer=stringBuffer.append(stringBuffer1);
            }
            System.out.println(stringBuffer);
        }

        public  boolean isEmpty(){
            return count==0?true:false;
        }

        public Object getTail(){
            return queue[end-1];
        }

}
