
public class Room {
	boolean withinPlan(HeatingPlan plan) {
		return plan.withinRange(daysTempRange());
	}

	private TempRange daysTempRange() {
		return new TempRange();
	}
}

class HeatingPlan {
	private TempRange _range;

	boolean withinRange(TempRange roomRange) {
		return (_range.includes(roomRange));
	}
}

class TempRange {
	private int low;
	private int high;

	public int getLow() {
		return low;
	}

	public int getHigh() {
		return high;
	}

	boolean includes(TempRange arg) {
		return arg.getLow() >= this.getLow() && arg.getHigh() <= this.getHigh();
	}
}
