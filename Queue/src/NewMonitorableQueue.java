
public class NewMonitorableQueue<T> implements IQueue<T>{
	private int currentSize;
	private int maxSize;
	private NewQueue<T> queue;
	
	public NewMonitorableQueue() {
		queue = new NewQueue<>();
		currentSize = 0;
		maxSize = 0;
	}
	
	@Override
	public boolean enqueue(T obj) throws IllegalStateException {
		if(++currentSize > maxSize) {
			maxSize = currentSize;
		}
		return queue.enqueue(obj);
	}
	
	@Override
	public T dequeue(T obj) throws IllegalStateException {
		--currentSize;
		return queue.dequeue(obj);
	}
	
	@Override
	public T peek() throws IllegalStateException {
		return queue.peek();
	}
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	@Override
	public boolean isFull() {
		return queue.isFull();
	}
}
