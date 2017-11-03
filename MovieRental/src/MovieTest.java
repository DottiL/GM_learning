import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {
private String movieTitle;
	
	public MovieTest() {
		movieTitle = "Test";
	}
	
	@Test
	public void testSetPriceCode() {
		Movie movie;
		
		//test regular price code
		movie = new Movie(movieTitle, 0);
		assertEquals(0, movie.getPriceCode());
		
		//test childrens price code
		movie = new Movie(movieTitle, 1);
		assertEquals(1, movie.getPriceCode());
		
		//test new release price code
		movie = new Movie(movieTitle, 2);
		assertEquals(2, movie.getPriceCode());
		
		//test invalid price code
		try {
			movie = new Movie(movieTitle, -1);
		} catch(IllegalArgumentException e){
			assertEquals("Incorrect Price Code", e.getMessage());
		}
	}
	
	@Test
	public void testGetFrequentRenterPoints() {
		Movie movie;
		
		//test with daysRented <= 1 and price code != NEW_RELEASE
		movie = new Movie(movieTitle, 0);
		assertEquals(1, movie.getFrequentRenterPoints(0));
		
		//test with daysRented <= 1 and price code == NEW_RELEASE
		movie = new Movie(movieTitle, 1);
		assertEquals(1, movie.getFrequentRenterPoints(1));
		
		//test with daysRented > 1 and price code != NEW_RELEASE
		movie = new Movie(movieTitle, 0);
		assertEquals(1, movie.getFrequentRenterPoints(2));
		
		//test with daysRented > 1 and price code == NEW_RELEASE
		movie = new Movie(movieTitle, 1);
		assertEquals(2, movie.getFrequentRenterPoints(2));
	}

	@Test
	public void testGetCharge() {
		Movie movie;
		
		//test childrens price with daysRented  <= 3
		movie = new Movie(movieTitle, 2);
		assertEquals(1.5, movie.getCharge(1), 0.0);
		
		//test childrens price with daysRented  > 3
		movie = new Movie(movieTitle, 2);
		assertEquals(3, movie.getCharge(4), 0.0);
		
		//test regular price with daysRented  <= 2
		movie = new Movie(movieTitle, 0);
		assertEquals(2, movie.getCharge(1), 0.0);
		
		//test regular price with daysRented  > 2
		movie = new Movie(movieTitle, 0);
		assertEquals(3.5, movie.getCharge(3), 0.0);
		
		//test new release price
		movie = new Movie(movieTitle, 1);
		assertEquals(3, movie.getCharge(1), 0.0);
	}
}
