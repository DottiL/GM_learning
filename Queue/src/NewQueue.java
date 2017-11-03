import java.util.ArrayList;
import java.util.List;

public class NewQueue<T> implements IQueue<T> {
	private List<T> queue;
	private int head;
	private int tail;
	private int max;
	
	public NewQueue() {
		queue = new ArrayList<>();
		head = 0;
		tail = 0;
		max = -1;
	}
	
	public NewQueue(int max) {
		queue = new ArrayList<>();
		head = 0;
		tail = 0;
		this.max = max;
	}

	@Override
	public boolean enqueue(T obj) throws IllegalStateException {
		if(isFull()) {
			throw new IllegalStateException();
		}
		
		queue.add(tail++, obj);
		
		return true;
	}

	@Override
	public T dequeue(T obj) throws IllegalStateException {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		
		return queue.remove(head++);
	}

	@Override
	public T peek() throws IllegalStateException {
		return queue.get(head);
	}

	@Override
	public boolean isEmpty() {
		return tail == head ? true : false;
	}

	@Override
	public boolean isFull() {
		return max == -1 || tail - head + 1 < max ? false : true;
	}

}
