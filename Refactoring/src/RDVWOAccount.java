import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class RDVWOAccount {
	private final Vector _entries = new Vector();

	double getFlowBetween(DateRange range) {
		double result = 0;
		Enumeration e = _entries.elements();
		while (e.hasMoreElements()) {
			Entry each = (Entry) e.nextElement();
            if (range.includes(each.getDate())) {
				result += each.getValue();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		double flow = new RDVWOAccount().getFlowBetween(new DateRange(null, null));
		flow = flow * 2;
	}
}

class DateRange {
	private final Date _start;
	private final Date _end;

	DateRange(Date start, Date end) {
		_start = start;
		_end = end;
	}

	Date getStart() {
		return _start;
	}

	Date getEnd() {
		return _end;
	}

	boolean includes(Date date) {
		return (date.equals(_start) || date.equals(_end) || (date.after(_start) && date.before(_end)));
	}

}
