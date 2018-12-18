public class Main {

    private int[] data;
    private int head;
    private int tail;
    private boolean empty;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public Main(int k) {
        data = new int[k];
        head = 0;
        tail = 0;
        empty = true;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (!isFull()) {
            if (empty == true) {
                empty = false;
            } else if (tail == data.length - 1) {
                tail = 0;
            } else {
                tail++;
            }
            data[tail] = value;
            return true;
        } else {
            return false;
        }
    }


    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            if(head == tail) {
                empty = true;
            } else if(head == data.length - 1){
                head = 0;
            } else {
                head++;
            }
            return true;
        }
        else return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty()) return data[head];
        else return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty()) return data[tail];
        else return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return empty;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(tail == data.length - 1 && head == 0){
            return true;
        } else if(tail + 1 == head){
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        Main circularQueue = new Main(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println( circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}

