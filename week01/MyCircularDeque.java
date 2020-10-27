/**
 * 设计循环双端队列
 *
 * 循环队列 : 知识点
 * capacity：数组容量
 * front：表示队列队首，始终指向队列中的第一个元素（当队列空时，front指向索引为0的位置）
 * tail：表示队列队尾，始终指向队列中的最后一个元素的下一个位置
 * 元素入队，维护tail的位置，进行tail++操作，计算公式：(tail + 1) % capacity
 * 元素出队，维护front的位置，进行front++操作，计算公式：(front + 1) % capacity
 * 在循环队列中，总是浪费一个空间，来区分队列为满时和队列为空时的情况，也就是当 (tail + 1) % capacity ==   front的时候，表示队列已经满了，当front == tail的时候，表示队列为空。
 *
 *
 */
class MyCircularDeque {
    int[] ring;
    int head = 0;
    int tail = 0;
    int capacity;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k + 1 ;
        this.ring = new int[capacity];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        } else{
            head = (head - 1 + capacity ) % capacity; //头指针往前一位，或到最后
            ring[head] = value;
            return true ;
        }

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) return false;
        ring[tail] = value ;
        tail = (tail + 1) % capacity ;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }else {
            head = (head + 1) % capacity ;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }else {
            tail = (tail - 1 + capacity) % capacity ;
            return true;
        }

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }else {
            return ring[head];
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }else {
            return ring[(tail-1+capacity) %capacity];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail ;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}
