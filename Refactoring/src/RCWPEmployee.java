/**
 * Replace Conditional with Polymorphism.
 * 
 * @author dev
 *
 */
public class RCWPEmployee {
	private RCWPEmployeeType _type;
    private int _monthlySalary;
    private int _commission;
    private int _bonus;
    
	int payAmount() {
        return _type.payAmount(this);
    }
	
	int getType() {
        return _type.getTypeCode();
    }
	
	public int getBonus() {
		return _bonus;
	}
	
	public int getCommission() {
		return _commission;
	}
	
	public int getMonthlySalary() {
		return _monthlySalary;
	}
}

abstract class RCWPEmployeeType {
	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;
	
	abstract int getTypeCode();
	
	abstract int payAmount(RCWPEmployee emp);
}

class RCWPEngineer extends RCWPEmployeeType {
	@Override
	int getTypeCode() {
	    return ENGINEER;
	}
	
	@Override
	int payAmount(RCWPEmployee emp) {
		return emp.getMonthlySalary();
	}
}

class RCWPSalesMan extends RCWPEmployeeType {
	
	@Override
	int getTypeCode() {
	    return SALESMAN;
	}
	
	@Override
	int payAmount(RCWPEmployee emp) {
		return emp.getMonthlySalary() + emp.getCommission();
	}
}

class RCWPManager extends RCWPEmployeeType {
	
	@Override
	int getTypeCode() {
	    return MANAGER;
	}
	
	@Override
	int payAmount(RCWPEmployee emp) {
		return emp.getMonthlySalary() + emp.getBonus();
	}
}
