package badSmell;

public class IAEmployee {
	private static final double NULL_EXPENSE = -1.0;
	private double _expenseLimit = NULL_EXPENSE;
	private Project _primaryProject;

	double getExpenseLimit() {
		Assert.isTrue(_expenseLimit != NULL_EXPENSE || _primaryProject!= null);
		return (_expenseLimit != NULL_EXPENSE) ? _expenseLimit : _primaryProject.getMemberExpenseLimit();
	}

	boolean withinLimit(double expenseAmount) {
		return (expenseAmount <= getExpenseLimit());
	}
}

class Project {
	double getMemberExpenseLimit() {
		return 0.0;
	}
}
