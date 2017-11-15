package com.app.models;

import java.util.List;
import java.util.Map;

import com.app.validation.RuleValidator;

public abstract class Model {
	protected boolean hasErrors;
	protected boolean isNew;
	protected Map<String, RuleValidator> validators;
	
	protected abstract void defineValidators();
	public abstract String getAttribute(String field);
	public abstract void setAttribute(String field, String fieldValue);
	
	public boolean hasErrors() {
		return hasErrors;
	}
	
	public boolean isNew() {
		return isNew;
	}
	
	public boolean fieldHasError(String field) {
		return validators.get(field).hasErrors();
	}

	public List<String> getErrorsForField(String field) {
		return validators.get(field).getErrors();
	}
	
	public void setAttributes(Map<String, String> fields) {
		isNew = false;
		
		String field;
		String fieldValue;
		RuleValidator currentValidator;
		
		for(Map.Entry<String, String> entry: fields.entrySet()) {
			field = entry.getKey();
			fieldValue = entry.getValue();
			currentValidator = validators.get(field);
			currentValidator.withValue(fieldValue).applyRules();
			
			if(!currentValidator.hasErrors()) {
				setAttribute(field, fieldValue);
			} else {
				hasErrors = hasErrors || currentValidator.hasErrors();
			}
		}
	}
}
