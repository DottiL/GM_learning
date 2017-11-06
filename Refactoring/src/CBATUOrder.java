import java.util.HashSet;
import java.util.Set;

/**
 * Change Bidirectional Association to Unidirectional.
 * 
 * @author dev
 *
 */
public class CBATUOrder {
	CBATUCustomer getCustomer() {
		return _customer;
	}

	void setCustomer(CBATUCustomer arg) {
		if (_customer != null)
			_customer.friendOrders().remove(this);
		_customer = arg;
		if (_customer != null)
			_customer.friendOrders().add(this);
	}

	private CBATUCustomer _customer;
}

class CBATUCustomer {
	void addOrder(CBATUOrder arg) {
		arg.setCustomer(this);
	}

	private final Set _orders = new HashSet();

	Set friendOrders() {
		/**
		 * should only be used by Order
		 */
		return _orders;
	}
}
