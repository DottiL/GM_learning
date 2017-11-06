import java.util.Collection;
import java.util.Iterator;

public class Order2 {
	private Customer _customer;

	public Order2(String customerName) {
		_customer = new Customer(customerName);
	}

	public Customer getCustomer() {
		return _customer;
	}

	public void setCustomer(String customerName) {
		_customer = new Customer(customerName);
	}
	
	public String getCustomerName() {
		return _customer.getName();
	}
	
	public static void main(String[] args) {
		Order2.numberOfOrdersFor(null, null);
	}
	
	private static int numberOfOrdersFor(Collection orders, String customer) {
		int result = 0;
		Iterator iter = orders.iterator();
		while (iter.hasNext()) {
			Order2 each = (Order2) iter.next();
			if (each.getCustomerName().equals(customer))
				result++;
		}
		return result;
	}
}

class Customer {
	private final String _name;

	public Customer(String _name) {
		this._name = _name;
	}

	public String getName() {
		return _name;
	}
}
