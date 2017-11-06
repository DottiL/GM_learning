/**
 * Replace type code with subclasses.
 * 
 * @author dev
 *
 */
public abstract class RTCWSEmployee {
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;
    
    static RTCWSEmployee create(int type) {
    	switch(type) {
	    	case ENGINEER:
	    		return new Engineer();
	    	case SALESMAN:
	    		return new Engineer();
	    	case MANAGER:
	    		return new Engineer();
    		default:
    			throw new IllegalArgumentException("Incorrect type code value");
    	}
    }
    
    abstract int getType();
}

class Engineer extends RTCWSEmployee {
	@Override
	int getType() {
		return RTCWSEmployee.ENGINEER;
	}
}

class Salesman extends RTCWSEmployee {
	@Override
	int getType() {
		return RTCWSEmployee.SALESMAN;
	}
}

class Manager extends RTCWSEmployee {
	@Override
	int getType() {
		return RTCWSEmployee.MANAGER;
	}
}