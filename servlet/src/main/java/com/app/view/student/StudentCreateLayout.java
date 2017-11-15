package com.app.view.student;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import java.util.ArrayList;
import java.util.List;

import com.app.models.Model;
import com.app.models.student.Student;
import com.github.manliogit.javatags.element.Element;

public class StudentCreateLayout {
	private final Model student;
	
	public StudentCreateLayout(Model student) {
		this.student = student;
	}
	
	protected String getAction() {
		return "action -> /student/create";
	}
	
	public Element build() {
		return html5(
				head(
					meta(attr("chartset -> utf-8")),
					meta(attr("http-equiv -> X-UA-Compatible", "content -> IE=edge")),
					meta(attr("name -> viewport", "content -> width=device-width, initial-scale=1")),
					title("Seminar"),
					link(attr("rel -> stylesheet", "href -> /css/bootstrap.min.css"))
				),
				body(
					div(attr("class -> col-lg-8 col-md-8 col-sm-9"),
						form(attr("class -> form-horizontal", "role -> form", "method -> post", getAction()),
							buildInput(Student.NAME),
							buildInput(Student.SURNAME),
							div(attr("class -> form-group"),
								div(attr("class -> col-sm-10 col-sm-offset-2"),
										input(attr("id -> submit", "name -> submit", "type -> submit", "value -> send", "class -> btn btn-primary"))
								)
							)
						)
					)
				)
			);
	}
	
	private Element buildInput(String studentField) {
		String divClass;
		String iconClass;
		List<Element> content = new ArrayList<>();

		if(!student.isNew()) {
			if(student.fieldHasError(studentField)) {
				divClass = getDivClassWithError();
				iconClass = getErrorIconClass();
				for(String error: student.getErrorsForField(studentField)) {
					content.add(span(attr("class -> help-block"), error));
				}
			} else {
				divClass = getDivClassWithSuccess();
				iconClass = getSuccessIconClass();
			}
		} else {
			divClass = getBlankDivClass();
			iconClass = getBlankIconClass();
		}
		
		content.add(0, input(attr("type -> text", "class -> form-control", "id -> " + studentField, "name -> " + studentField, 
				"aria-describedby -> " + studentField + "_feedback", "value -> " + student.getAttribute(studentField))));
		content.add(1, span(attr("class -> " + iconClass, "aria-hidden -> true")));
		content.add(2, span(attr("id -> " + studentField + "_feedback", "class -> sr-only")));
		
		return div(attr("class -> " + divClass),
				label(attr("for -> " + studentField, "class -> col-sm-2 control-label"), studentField),
				div(attr("class -> col-sm-10"), 
					content
				),
				span()
			);
	}
	
	private String getBlankDivClass() {
		return "form-group";
	}
	
	private String getBlankIconClass() {
		return "";
	}
	
	private String getErrorIconClass() {
		return "glyphicon glyphicon-remove form-control-feedback";
	}
	
	private String getSuccessIconClass() {
		return "glyphicon glyphicon-ok form-control-feedback";
	}
	
	private String getDivClassWithError() {
		return "form-group has-error";
	}
	
	private String getDivClassWithSuccess() {
		return "form-group has-success";
	}
}
