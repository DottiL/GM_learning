package validators.rules;

public class MaxLengthValidationRule implements ValidationRule{
	private int maxLength;
	private final String sizeErrorMsg = "maximum length is ";
	private boolean hasError;
	
	public MaxLengthValidationRule(int maxLength) {
		this.maxLength = maxLength;
	}
	
	@Override
	public boolean validate(String field) {
		System.out.println("With value " + field);
		hasError = !(field.length() <= maxLength);
		return hasError;
	}

	@Override
	public String getErrorMessage() {
		return hasError ? (sizeErrorMsg + Integer.toString(maxLength)) : null;
	}

	@Override
	public boolean hasError() {
		return hasError;
	}

}
