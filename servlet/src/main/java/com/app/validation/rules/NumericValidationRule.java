package com.app.validation.rules;

public class NumericValidationRule implements ValidationRule{
	private final String errorMsg = "must be a number";
	private String format;
	private boolean hasError;
	
	public NumericValidationRule() {
		format = "-?\\d+(\\.\\d+)?";
	}
	
	@Override
	public boolean validate(String field) {
		hasError = !isNumber(field);
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
	
	private boolean isNumber(String number) {
		return number.matches(format);
	}

}
