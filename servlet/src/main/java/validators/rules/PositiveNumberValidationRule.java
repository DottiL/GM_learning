package validators.rules;

public class PositiveNumberValidationRule implements ValidationRule {
	private final String errorMsg = "must be positive";
	private boolean hasError;
	
	@Override
	public boolean validate(String field) {
		System.out.println("With value " + field);
		int value;
		try {
			value = Integer.parseInt(field);
			hasError = !(value >= 0);
		} catch(Exception e) {
			hasError = true;
		}
		
		return hasError;
	}

	@Override
	public String getErrorMessage() {
		return hasError ? errorMsg : null;
	}

	@Override
	public boolean hasError() {
		return hasError;
	}

}
