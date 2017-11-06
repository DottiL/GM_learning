/**
 * Hide delegate.
 * 
 * @author dev
 *
 */
public class HDPerson {
	HDDepartment _department;

	public HDDepartment getDepartment() {
		return _department;
	}

	public void setDepartment(HDDepartment arg) {
		_department = arg;
	}
	
	public static void main(String[] args) {
		HDPerson john = new HDPerson();
		john.getManager();
	}
	
	public HDPerson getManager() {
		return _department.getManager();
	}
}

class HDDepartment {
	private String _chargeCode;
	private final HDPerson _manager;

	public HDDepartment(HDPerson manager) {
		_manager = manager;
	}

	public HDPerson getManager() {
		return _manager;
	}
}
