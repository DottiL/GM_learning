package validators;

import java.util.ArrayList;
import java.util.List;

import validators.rules.ValidationRule;

public class RuleValidator {
	private String fieldName;
	private String fieldValue;
	private boolean hasError;
	private List<ValidationRule> rules;
	
	public RuleValidator() {
		rules = new ArrayList<>();
		hasError = false;
	}
	
	public void forField(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public RuleValidator withValue(String fieldValue) {
		this.fieldValue = fieldValue;
		return this;
	}
	
	public void addRule(ValidationRule rule) {
		rules.add(rule);
	}
	
	public void applyRules() {
		System.out.println("Field " + fieldName + " on value " + fieldValue);
		for(ValidationRule rule: rules) {
			hasError = hasError || rule.validate(fieldValue);
			System.out.println("Applying " + rule.getClass() + " " + rule.hasError());
		}
		System.out.println("------");
	}
	
	public boolean hasErrors() {
		return hasError;
	}
	
	public List<String> getErrors() {
		System.out.println("Errors for " + fieldName);
		List<String> errors = new ArrayList<>();
		
		String error;
		for(ValidationRule rule: rules) {
			if(rule.hasError()) {
				error = rule.getErrorMessage();
				if(error != null) {
					errors.add(fieldName + " " + error);
					System.out.println(error);
				}
				
			}
		}
		System.out.println("------");
		
		return errors;
	}

}
