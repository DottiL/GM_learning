public class RTCWPPerson {
	public static final int O = BloodGroup.O.getCode();
	public static final int A = BloodGroup.A.getCode();
	public static final int B = BloodGroup.B.getCode();
	public static final int AB = BloodGroup.AB.getCode();
	private BloodGroup _bloodGroup;

	public RTCWPPerson(int bloodGroup) {
		_bloodGroup = BloodGroup.code(bloodGroup);
	}

	public void setBloodGroup(int arg) {
		_bloodGroup = BloodGroup.code(arg);
	}

	public int getBloodGroup() {
		return _bloodGroup.getCode();
	}
}

class BloodGroup {
	public final static BloodGroup O = new BloodGroup(0);
	public final static BloodGroup A = new BloodGroup(1);
	public final static BloodGroup B = new BloodGroup(2);
	public final static BloodGroup AB = new BloodGroup(3);
	private final static BloodGroup[] _values = { O, A, B, AB };

	private final int _code;

	public BloodGroup(int code) {
		_code = code;
	}

	public int getCode() {
		return _code;
	}

	public static BloodGroup code(int arg) {
		return _values[arg];
	}
}