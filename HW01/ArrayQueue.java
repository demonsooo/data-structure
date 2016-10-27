/*NAME  : YIJIA LIU
DATE  : 13 Jan 2015
CLASS : CSE373 A
Detail: Homework 1
This is a class defining a circular array queue.
*/
public class ArrayQueue {
	private String[] queueArray;
	private int size;
	private int front;
	private int back;
	
	public ArrayQueue(){
		queueArray = new String[100];
		size = 0;
		front = 0;
		back = -1;
	}
	
	public ArrayQueue(int startSize){
		queueArray = new String[startSize];
		size = 0;
		front = 0;
		back = -1;
	}
	
	/**
	 * @function returns the number of elements in the queue
	 * @return size
	 */	
	public int getSize(){
		return size;
	}
	/**
	 * @function adds a string to the end of the queue
	 * @param toEnqueue: the input to be inserted
	 */
	public void enqueue(String toEnqueue){
		//TODO implement enqueue
		if(isFull()){
         //throw an exception if the array queue is full
			throw new IllegalArgumentException("Queue is full");
		} else {
			queueArray[(back + 1) % queueArray.length] = toEnqueue;//put the element to the back of array
			back = back + 1;//move the pointer of back	
         size++;	
		}
	}
	
	/**
	 * @function removes the string from the front of the queue
	 * @return the string from the front of the queue
	 */
	public String dequeue(){
		//TODO implement dequeue
		String toDequeue = queueArray[front];
		queueArray[front] = "";//remove the first element
		front = (front + 1) % queueArray.length;//move the pointer of front
      size--;
		return toDequeue;
	}
	
	/**
	 * 
	 * @return returns true if the queue is empty, false otherwise
	 */
	public boolean isEmpty(){
		//TODO implement isEmpty
		if(size == 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @return returns true if the queue is full, false otherwise
	 */
	public boolean isFull(){
		//TODO implement isFull
		if(size == queueArray.length)
			return true;
		return false;
	}
	
}
