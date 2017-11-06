package badSmell;

import java.util.Date;

public class MfDateSub extends Date {
	Date nextDay() {
		return new Date(getYear(), getMonth(), getDate() + 1);
	}
}

class MfDateWrap {
	private Date date;

	public MfDateWrap(Date arg) {
		date = arg;
	}

	public MfDateWrap(String dateString) {
		date = new Date(dateString);
	};

	public int getYear() {
		return date.getYear();
	}

	public boolean equals (MfDateWrap arg) {
	       return (toDate().equals(arg.toDate()));
	   }

}
