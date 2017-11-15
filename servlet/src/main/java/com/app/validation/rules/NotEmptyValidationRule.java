package com.app.validation.rules;

public class NotEmptyValidationRule implements ValidationRule {
	private final String errorMsg = "can't be empty";
	private boolean hasError;
	
	@Override
	public boolean validate(String field) {
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
