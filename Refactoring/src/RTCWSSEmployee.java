/**
 * Replace Type Code with State/Strategy.
 * 
 * @author dev
 *
 */
public class RTCWSSEmployee {
	private EmployeeType _type;
	
	private int _monthlySalary;
	private int _commission;
	private int _bonus;

	RTCWSSEmployee(int type) {
		setType(type);
	}

	public int getType() {
		return _type.getTypeCode();
	}

	public void setType(int type) {
		_type = EmployeeType.newType(type);
	}

	int payAmount() {
		switch (getType()) {
		case EmployeeType.ENGINEER:
			return _monthlySalary;
		case EmployeeType.SALESMAN:
			return _monthlySalary + _commission;
		case EmployeeType.MANAGER:
			return _monthlySalary + _bonus;
		default:
			throw new RuntimeException("Incorrect Employee");
		}
	}
}

abstract class EmployeeType {
	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	abstract int getTypeCode();
	
	static EmployeeType newType(int code) {
		switch (code) {
			case ENGINEER:
				return new RTCWSSEngineer();
			case SALESMAN:
				return new RTCWSSSalesman();
			case MANAGER:
				return new RTCWSSManager();
			default:
				throw new IllegalArgumentException("Incorrect Employee Code");
		}
	}
}

class RTCWSSEngineer extends EmployeeType {
	@Override
	int getTypeCode() {
		return EmployeeType.ENGINEER;
	}
}

class RTCWSSManager extends EmployeeType {
	@Override
	int getTypeCode() {
		return EmployeeType.MANAGER;
	}
}

class RTCWSSSalesman extends EmployeeType {
	@Override
	int getTypeCode() {
		return EmployeeType.SALESMAN;
	}
}