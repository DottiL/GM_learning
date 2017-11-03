public interface IQueue<T> {	
	public boolean enqueue(T obj) throws IllegalStateException;
	public T dequeue(T obj) throws IllegalStateException;
	public T peek() throws IllegalStateException;
	public boolean isEmpty();
	public boolean isFull();
}
