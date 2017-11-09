package validators.rules;

public class NotEmptyValidationRule implements ValidationRule {
	private final String errorMsg = "can't be empty";
	private boolean hasError;
	
	@Override
	public boolean validate(String field) {
		System.out.println("With value " + field);
		hasError = !notEmpty(field);
		return hasError;
	}

	@Override
	public String getErrorMessage() {
		return hasError ? (errorMsg) : null;
	}
	
	private boolean notEmpty(String field) {
		return !field.equals("") && field != null;
	}

	@Override
	public boolean hasError() {
		return hasError;
	}

}
