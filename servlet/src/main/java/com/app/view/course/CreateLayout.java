package com.app.view.course;

import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.body;
import static com.github.manliogit.javatags.lang.HtmlHelper.div;
import static com.github.manliogit.javatags.lang.HtmlHelper.form;
import static com.github.manliogit.javatags.lang.HtmlHelper.head;
import static com.github.manliogit.javatags.lang.HtmlHelper.html5;
import static com.github.manliogit.javatags.lang.HtmlHelper.input;
import static com.github.manliogit.javatags.lang.HtmlHelper.label;
import static com.github.manliogit.javatags.lang.HtmlHelper.link;
import static com.github.manliogit.javatags.lang.HtmlHelper.meta;
import static com.github.manliogit.javatags.lang.HtmlHelper.span;
import static com.github.manliogit.javatags.lang.HtmlHelper.title;

import java.util.ArrayList;
import java.util.List;

import com.github.manliogit.javatags.element.Element;
import com.seminar.Course;

public class CreateLayout {
	private Course course;
	
	public CreateLayout(Course course) {
		this.course = course;
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
						form(attr("class -> form-horizontal", "role -> form", "method -> post", "action -> /course/create"),
							buildInput(Course.NAME),
							buildInput(Course.TOTAL_SEATS),
							buildInput(Course.STARTING_DATE),
							buildInput(Course.LOCATION),
							buildInput(Course.DESCRIPTION),
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

	private Element buildInput(String courseField) {
		String divClass;
		String iconClass;
		List<Element> content = new ArrayList<>();

		if(!course.isNew()) {
			if(course.fieldHasError(courseField)) {
				divClass = getDivClassWithError();
				iconClass = getErrorIconClass();
				for(String error: course.getErrorsForField(courseField)) {
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
		
		content.add(0, input(attr("type -> text", "class -> form-control", "id -> " + courseField, "name -> " + courseField, 
				"aria-describedby -> " + courseField + "_feedback", "value -> " + course.getAttribute(courseField))));
		content.add(1, span(attr("class -> " + iconClass, "aria-hidden -> true")));
		content.add(2, span(attr("id -> " + courseField + "_feedback", "class -> sr-only")));
		
		return div(attr("class -> " + divClass),
				label(attr("for -> " + courseField, "class -> col-sm-2 control-label"), courseField),
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
