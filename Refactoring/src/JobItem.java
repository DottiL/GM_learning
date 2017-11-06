
public class JobItem {
	private final int _unitPrice;
    private final int _quantity;
    protected Employee _employee;
    
    protected JobItem (int unitPrice, int quantity) {
        _unitPrice = unitPrice;
        _quantity = quantity;
    }
    
    public int getTotalPrice() {
        return getUnitPrice() * _quantity;
    }
    
    public int getUnitPrice(){
        return _unitPrice;
    }
    
    public int getQuantity(){
        return _quantity;
    }
    
    protected boolean isLabor() {
    	return false;
    }
    
}

class LaborItem extends JobItem {

	public LaborItem(int quantity, Employee employee) {
		super(0, quantity);
		_employee = employee;
	}
	
	@Override
	protected boolean isLabor() {
    	return true;
    }
	
	public Employee getEmployee() {
        return _employee;
    }
	
	@Override
	public int getUnitPrice() {
		return _employee.getRate();
	}
	
}

class Employee {
	private final int _rate;
	
	public Employee (int rate) {
        _rate = rate;
    }
    public int getRate() {
        return _rate;
    }
}