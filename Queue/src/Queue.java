import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	private List<T> queue;
	private int head;
	private int tail;
	private int max;
	
	public Queue() {
		queue = new ArrayList<>();
		head = 0;
		tail = 0;
		max = -1;
	}
	
	public Queue(int max) {
		queue = new ArrayList<>();
		head = 0;
		tail = 0;
		this.max = max;
	}
	
	public boolean enqueue(T obj) throws IllegalStateException {
		if(isFull()) {
			throw new IllegalStateException();
		}
		
		queue.add(tail++, obj);
		
		return true;
	}
	
	public T dequeue() throws IllegalStateException {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		
		return queue.remove(head++);
	}
	
	public T peek() {
		return queue.get(head);
	}
	
	public boolean isEmpty() {
		return tail == head ? true : false;
	}
	
	public boolean isFull() {
		return max == -1 || tail - head + 1 < max ? false : true;
	}

}
