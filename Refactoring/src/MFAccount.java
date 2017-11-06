/**
 * Move field.
 * 
 * @author dev
 *
 */
public class MFAccount {
	private AccountType _type;
	
	double interestForAmount_days(double amount, int days) {
		return _type.getInterestRate() * amount * days / 365;
	}
}
