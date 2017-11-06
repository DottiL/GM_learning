package badSmell;

/**
 * Encapsulate field.
 * 
 * @author dev
 *
 */
public class IntRange {
	private int _low, _high;

	boolean includes(int arg) {
		return arg >= get_low() && arg <= get_high();
	}

	void grow(int factor) {
		set_high(get_high() * factor);
	}

	IntRange(int low, int high) {
		_low = low;
		_high = high;
	}

	private void initialize(int low, int high) {
		_low = low;
		_high = high;
	}

	public int get_high() {
		return _high;
	}

	public int get_low() {
		return _low;
	}

	public void set_high(int _high) {
		this._high = _high;
	}

	public void set_low(int _low) {
		this._low = _low;
	}
}

class CappedRange extends IntRange {
	CappedRange(int low, int high, int cap) {
		super(low, high);
		_cap = cap;
	}

	private int _cap;

	int getCap() {
		return _cap;
	}

	int getHigh() {
		return Math.min(super.get_high(), getCap());
	}
}
