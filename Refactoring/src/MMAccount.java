/**
 * Move method.
 * 
 * @author dev
 *
 */
public class MMAccount {
	private AccountType _type;
	private int _daysOverdrawn;
	
	double bankCharge() {
		double result = 4.5;
		if (_daysOverdrawn > 0)
			result += _type.overdraftCharge(this);
		return result;
	}
	
	public int getDaysOverdrawn() {
		return _daysOverdrawn;
	}
}

class AccountType {
	private double _interestRate;
	
	public double getInterestRate() {
		return _interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		_interestRate = interestRate;
	}
	
	public boolean isPremium() {
		return false;
	}
	
	double overdraftCharge(MMAccount account) {
		if (isPremium()) {
			double result = 10;
			if (account.getDaysOverdrawn() > 7)
				result += (account.getDaysOverdrawn() - 7) * 0.85;
			return result;
		} else
			return account.getDaysOverdrawn() * 1.75;
	}
}
