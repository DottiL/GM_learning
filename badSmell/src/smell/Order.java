package smell;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

public class Order {

	private final Vector<LineItem> lineItemList;

	public Order(Vector<LineItem> lineItemList) {
		this.lineItemList = lineItemList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Order)) {
			return false;
		}

		return this.lineItemList.equals(((Order) obj).lineItemList);
	}

	public void writeOrder(PrintWriter printWriter) {
		printWriter.println(getPrintableList());
	}
	
	private String getPrintableList() {
		String result = "";
		Iterator<LineItem> iter = lineItemList.iterator();
		while (iter.hasNext()) {
			result += iter.next().toString() + "\n";
		}
		
		result += "Order total = " + getTotalListPrice();
		
		return result;
	}
	
	private int getTotalListPrice() {
		Iterator<LineItem> iter = lineItemList.iterator();
		
		int total = 0;
		while (iter.hasNext()) {
			total += iter.next().getTotalPrice();
		}
		
		return total;
	}

	private String getInsertStatement() {
		return new StringBuffer().append("INSERT INTO T_ORDER ").append("(AUTHORIZATION_CODE, ")
				.append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) ")
				.append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();
	}
	
	/** This method saves the order to the database */
	public void saveOrder() throws SQLException {
		new DatabaseManager("", "", "").executeUpdate(getInsertStatement());
	}
}
