import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTest {
	private String customerName;
	
	public CustomerTest() {
		customerName = "Test";
	}

	@Test
	public void testStatement() {
		Customer customer = new Customer(customerName);
		
		//test no rentals
		assertEquals(buildStatementExpectation(0, 0, 0), customer.statement());
		
		//test some rentals
		customer.addRental(new Rental(new Movie("test", 0), 1));
		customer.addRental(new Rental(new Movie("test", 0), 1));
		customer.addRental(new Rental(new Movie("test", 0), 1));
		assertEquals(buildStatementExpectation(3, 2.0, 3), customer.statement());
		
	}
	
	@Test
	public void testHtmlStatement() {
		Customer customer = new Customer(customerName);
		
		//test no rentals
		assertEquals(buildHtmlStatementExpectation(0, 0, 0), customer.htmlStatement());
		
		//test some rentals
		customer.addRental(new Rental(new Movie("test", 0), 1));
		customer.addRental(new Rental(new Movie("test", 0), 1));
		customer.addRental(new Rental(new Movie("test", 0), 1));
		assertEquals(buildHtmlStatementExpectation(3, 2.0, 3), customer.htmlStatement());
		
	}
	
	private String buildStatementExpectation(int nbRentals, double eachRentalCharge, int totalFrequentRenterPoints) {
		String expectation = "Rental Record for " + customerName + "\n";
		double totalCharge = nbRentals * eachRentalCharge;
		
		if(nbRentals > 0) {
			for (int i = 0; i < nbRentals; i++) {
				expectation += "\ttest\t" + eachRentalCharge + "\n";
				
			}
		}
		
		return expectation
				+ "Amount owed is " + String.valueOf(totalCharge) + "\n"
				+ "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";
	}
	
	private String buildHtmlStatementExpectation(int nbRentals, double eachRentalCharge, int totalFrequentRenterPoints) {
		String expectation = "<H1>Rentals for <EM>" + customerName + "</EM></H1><P>\n";
		double totalCharge = nbRentals * eachRentalCharge;
		
		if(nbRentals > 0) {
			for (int i = 0; i < nbRentals; i++) {
				expectation +=  "test: " + eachRentalCharge + "<BR>\n";
			}
		}
		
		return expectation
				+ "<P>You owe <EM>" + String.valueOf(totalCharge) + "</EM><P>\n" 
				+ "On this rental you earned <EM>" + String.valueOf(totalFrequentRenterPoints)
				+ "</EM> frequent renter points<P>";
	}

}
