package RingBuffer;

/**
 * Program 7
 * A queue data structure implementation
 * CS108-2
 * 22 April 2020
 * @author Marcus Casillas
 */

public class RingBuffer<E> implements QueueInterface<E>{
	private E[] buffer;
	private int size;
	//indexes
	private int front;
	private int rear;
	
	@SuppressWarnings("unchecked")
	public RingBuffer(){
		buffer = (E[]) new Object[10];
		size = 0;
		front = -1;
		rear = -1;
	}
	
	@SuppressWarnings("unchecked")
	public RingBuffer(int bufferSize) {
		buffer = (E[]) new Object[bufferSize];
		size = 0;
		front = -1;
		rear = -1;
	}
	
	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean enQueue(E item) {
		if(isFull()) {
			return false;
		} else if(size == 0) {
			buffer[0] = item;
			front = 0;
			rear = 0;
			size++;
			return true;
		}
		//update rear pointer
		rear = (rear+1)%buffer.length;
		buffer[rear] = item;
		size++;
		return true;
	}
	
	@Override
	public E deQueue() {
		if(isEmpty()) {
			return null;
		}
		if(size == 1) {
			front = -1;
			rear = -1;
			size--;
			return buffer[front];
		}
		E frontValue = buffer[front];
		//update front pointer
		front = (front+1)%buffer.length;
		size--;
		return frontValue;
	}
	
	@Override
	public E peek() {
		if(isEmpty()) {
			return null;
		}
		return buffer[front];
	}
	
	/**
	 * Checks if the buffer is full, if it is, the method returns true, and false otherwise
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		if(size == buffer.length) {
			return true;
		}
		return false;
	}
	
	/**
	 * gets the rear element in the queue
	 * 
	 * @return Integer, null if queue is empty
	 */
	public E last() {
		if(size == 0) {
			return null;
		}
		return buffer[rear];
	}
	
	public E[] getArray() {
		return buffer;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return buffer.length;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "";
		}
		String queueString = "";
		for(int i = front; i != rear; ++i) {
			i %= buffer.length;
			queueString += (buffer[i] + ", ");
		}
		queueString += (last());
		return queueString;
	}
	
	public String getInfo() {
		return "Program 7, Marcus Casillas";
	}
}
