import java.util.ArrayList;

/* Queue.java
 * Vladimir Costescu
 * AP Computer Science AB
 * Assignment-3.2-QueueImplement (due 01/28/09)
 * This class implements a queue using an ArrayList.
 */

public class Queue {
	protected ArrayList<Object> queueArrayList;
	
	public Queue(){
		queueArrayList = new ArrayList<Object>();
	}
	public boolean isEmpty(){
		return queueArrayList.isEmpty();
	}
	public Object peek(){
		return queueArrayList.get(queueArrayList.size() - 1);
	}
	public void add(Object obj){
		queueArrayList.add(0, obj);
	}
	public Object remove(){
		Object returnObj = queueArrayList.get(queueArrayList.size() - 1);
		queueArrayList.remove(queueArrayList.size() - 1);
		
		return returnObj;
	}
}
