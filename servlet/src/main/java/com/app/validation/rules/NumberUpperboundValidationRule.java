package com.app.validation.rules;

public class NumberUpperboundValidationRule implements ValidationRule {
	private final String errorMsg = "must be less than";
	private int upperBound;
	private boolean hasError;
	
	public NumberUpperboundValidationRule(int upperBound) {
		this.upperBound = upperBound;
	}
	
	@Override
	public boolean validate(String field) {
		int value;
		try {
			value = Integer.parseInt(field);
			hasError = !(value <= upperBound);
		} catch(Exception e) {
			hasError = true;
		}
		
		return hasError;
	}

	@Override
	public String getErrorMessage() {
		return hasError ? errorMsg + " " + upperBound : null;
	}

	@Override
	public boolean hasError() {
		return hasError;
	}
}
