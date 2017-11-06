import java.util.Date;

public class DecomposeConditionals {
	public final static Date SUMMER_START = null;
	public final static Date SUMMER_END = null;
	private double _winterRate;
	private double quantity;
	private double _winterServiceCharge;
	private double _summerRate;
	
	public double getCharge(Date date) {
		double charge;
		if (isNotSummer(date))
			charge = winterCharge();
		else
			charge = summerCharge();
		
		return charge;
	}
	
	private boolean isNotSummer(Date date) {
		return date.before(SUMMER_START) || date.after(SUMMER_END);
	}
	
	private double winterCharge() {
		return quantity * _winterRate + _winterServiceCharge;
	}
	
	private double summerCharge() {
		return quantity * _summerRate;
	}
}
