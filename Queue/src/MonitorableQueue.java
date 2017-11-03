public class MonitorableQueue<T> extends Queue<T> {
	private int currentSize;
	private int maxSize;
	
	@Override
	public boolean enqueue(T obj) throws IllegalStateException {
		if(++currentSize > maxSize) {
			maxSize = currentSize;
		}
		
		return super.enqueue(obj);
	}
	
	@Override
	public T dequeue() throws IllegalStateException {
		--currentSize;
		return super.dequeue();
	}
	
	public int maxSize() {
		return maxSize;
	}
}
