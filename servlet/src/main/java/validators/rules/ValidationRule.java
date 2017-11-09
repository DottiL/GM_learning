package validators.rules;

public interface ValidationRule {
	public boolean validate(String field);
	public String getErrorMessage();
	public boolean hasError();
}
