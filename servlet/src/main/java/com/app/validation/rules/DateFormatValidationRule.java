package com.app.validation.rules;

public class DateFormatValidationRule implements ValidationRule {
	private final String errorMsg = "date format must be ";
	private String format;
	private String regex;
	private boolean hasError;
	
	public DateFormatValidationRule(String format, String regex) {
		this.format = format;
		this.regex = regex;
	}
	
	@Override
	public boolean validate(String field) {
		hasError = !isValidDateFormat(field);
		return hasError;
	}

	@Override
	public String getErrorMessage() {
		return hasError ? errorMsg + format : null;
	}

	@Override
	public boolean hasError() {
		return hasError;
	}
	
	private boolean isValidDateFormat(String date) {
		return date.matches(regex);
	}

}
