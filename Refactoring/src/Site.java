/**
 * Introduce null object.
 * 
 * @author dev
 *
 */
public class Site {
	INOCustomer _customer;
	INOCustomer getCustomer() {
        return _customer == null ? INOCustomer.newNull() : _customer;
    }
}

class INOCustomer implements Nullable {
	public String getName() {return null;}
    public BillingPlan getPlan() {return null;}
    public PaymentHistory getHistory() {return null;}
    
    protected INOCustomer() {
    	
    }
    
    @Override
	public boolean isNull() {
		return false;
	}
    
    static INOCustomer newNull() {
    	return new NullCustomer();
    }
}

class NullCustomer extends INOCustomer {
	@Override
	public boolean isNull() {
		return true;
	}
}

class BillingPlan {
	
}

class PaymentHistory {
	int getWeeksDelinquentInLastYear() {return 0;}
}

interface Nullable {
   boolean isNull();
 }
