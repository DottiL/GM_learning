import java.util.Enumeration;
import java.util.Vector;

public class ExtractMethod {
	private Vector _orders;
	private String _name;
	void printOwing(double previousAmount) {
		printBanner();
		double outstanding = getOutstanding(previousAmount * 1.2);
		printDetails(outstanding);
	}

	private double getOutstanding(double initialValue) {
		double result = initialValue;
		Enumeration e = _orders.elements();
		while (e.hasMoreElements()) {
			Order each = (Order) e.nextElement();
			result += each.getAmount();
		}
		return result;
	}

	private void printDetails(double outstanding) {
		System.out.println("name:" + _name);
		System.out.println("amount" + outstanding);
	}

	private void printBanner() {
		System.out.println("**************************");
		System.out.println("***** Customer Owes ******");
		System.out.println("**************************");
	}
}

class Order {
	public double getAmount() {
		return 0.0;
	}
}
