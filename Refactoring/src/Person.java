public class Person {
	private String _name;
	private final TelephoneNumber _officeTelephone = new TelephoneNumber();

	public String getName() {
		return _name;
	}

	public String getTelephoneNumber() {
		return _officeTelephone.getTelephoneNumber();
	}

	TelephoneNumber getOfficeTelephone() {
		return _officeTelephone;
	}

}
