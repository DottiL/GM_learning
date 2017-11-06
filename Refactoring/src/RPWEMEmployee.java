/**
 * Replace Parameter with Explicit Methods.
 * 
 * @author dev
 *
 */
public class RPWEMEmployee {
	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;

	static Employee create(int type) {
		switch (type) {
		case ENGINEER:
			return createEngineer();
		case SALESMAN:
			return createSalesman();
		case MANAGER:
			return createManager();
		default:
			throw new IllegalArgumentException("Incorrect type code value");
		}
	}
	
	private static Employee createEngineer() {
		return null;
	}
	
	private static Employee createSalesman() {
		return null;
	}
	
	private static Employee createManager() {
		return null;
	}
}
