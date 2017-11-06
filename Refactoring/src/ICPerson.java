/**
 * Inline class.
 * 
 * @author dev
 *
 */
public class ICPerson {
	private String _name;
	private final ICTelephoneNumber _officeTelephone = new ICTelephoneNumber();

	public String getName() {
		return _name;
	}

	public String getTelephoneNumber() {
		return _officeTelephone.getTelephoneNumber();
	}

	ICTelephoneNumber getOfficeTelephone() {
		return _officeTelephone;
	}
	
	String getAreaCode() {
		return _officeTelephone.getAreaCode();
	}

	void setAreaCode(String arg) {
		_officeTelephone.setAreaCode(arg);
	}

	String getNumber() {
		return _officeTelephone.getNumber();
	}

	void setNumber(String arg) {
		_officeTelephone.setNumber(arg);

	}
}

class ICTelephoneNumber {
	public String getTelephoneNumber() {
		return ("(" + _areaCode + ") " + _number);
	}

	String getAreaCode() {
		return _areaCode;
	}

	void setAreaCode(String arg) {
		_areaCode = arg;
	}

	String getNumber() {
		return _number;
	}

	void setNumber(String arg) {
		_number = arg;
	}

	private String _number;
	private String _areaCode;
}