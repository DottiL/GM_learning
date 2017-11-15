package com.app.view.course;

import java.util.List;

import com.app.models.Model;
import com.app.models.course.Course;

public class CourseAdminLayout {
	private final List<Model> courses;
	
	public CourseAdminLayout(List<Model> courses) {
		this.courses = courses;
	}
	
	public String render() {
		return "<html lang=\"en\">" +
					"<head>" +
						"<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">" +
						"<meta charset=\"utf-8\">" +
						"<title>courses</title>" +
						"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">" +
						"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
						"<link rel=\"stylesheet\" href=\"/css/bootstrap.min.css?v=1.0.0\" media=\"screen\">" +
						"<link rel=\"stylesheet\" href=\"/css/custom.css?v=1.0.0\">" +
						"<link rel=\"stylesheet\" href=\"/css/app.css?v=1.0.0\">" +
						"<!--[if lt IE 9]>" +
							"<script src='https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js'></script>" +
							"<script src='https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js'></script>" +
						"<![endif]-->" +
					"</head>" +
					"<body>" +
						"<div class=\"navbar navbar-default navbar-fixed-top\">" +
							"<div class=\"container\">" +
								"<div class=\"navbar-header\">" +
									"<a href=\"/\" class=\"navbar-brand\">Seminar</a>" +
									"<button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-main\"><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span><span class=\"icon-bar\"></span></button>" +
								"</div>" +
								"<div class=\"navbar-collapse collapse\" id=\"navbar-main\">" +
									"<ul class=\"nav navbar-nav navbar-right\">" +
										"<li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" id=\"download\" aria-expanded=\"false\">Account <span class=\"caret\"></span></a>" +
											"<ul class=\"dropdown-menu\" aria-labelledby=\"download\">" +
												"<li><a href=\"/\">settings</a></li>" +
												"<li class=\"divider\"></li>" +
												"<li><a href=\"/\">logout</a></li>" +
											"</ul>" +
										"</li>" +
									"</ul>" +
								"</div>" +
							"</div>" +
						"</div>" +
						"<div class=\"container\">" +
							"<div class=\"page-header\" id=\"banner\">" +
								"<div class=\"row\">" +
									"<div class=\"col-lg-8 col-md-7 col-sm-6\">" +
										"<h1>Seminar</h1>" +
										"<p class=\"lead\">Manage your courses!</p>" +
									"</div>" +
								"</div>" +
								"<div class=\"row\">" +
									"<div class=\"col-lg-2 col-md-2 col-sm-3\">" +
										"<div class=\"list-group table-of-contents\">" +
											"<a class=\"list-group-item\" href=\"/course\">List</a>" +
											"<a class=\"list-group-item\" href=\"/course/create\">Create</a>" +
										"</div>" +
									"</div>" +
									"<div class=\"col-lg-8 col-md-8 col-sm-9\">" +
										"<table class=\"table table-striped\">" +
											"<thead>" +
												"<tr>" +
													"<th>actions</th>" +
													"<th>name</th>" +
													"<th>location</th>" +
													"<th>totalSeats</th>" +
													"<th>start</th>" +
												"</tr>" +
											"</thead>" +
											"<tbody>" +
												insertCourses() +
											"</tbody>" +
										"</table>" +
									"</div>" +
								"</div>" +
							"</div>" +
							"<footer>" +
								"<div class=\"row\">" +
									"<div class=\"col-lg-12\">" +
										"<p><a href=\"http://bootswatch.com/cerulean\" rel=\"nofollow\">Cerulean theme</a></p>" +
										"<p>Code released under the <a href=\"https://github.com/thomaspark/bootswatch/blob/gh-pages/LICENSE\">MIT License</a>.</p>" +
										"<p>GmTechnologies</p>" +
									"</div>" +
								"</div>" +
							"</footer>" +
						"</div>" +
						"<script src=\"/js/jquery.min.js?v=1.0.0\"></script>" +
						"<script src=\"/js/bootstrap.min.js?v=1.0.0\"></script>" +
						"<script src=\"/js/custom.js?v=1.0.0\"></script>" +
					"</body>" +
				"</html>";						
								
	}
	
	private String insertCourses() {
		String tableBody = "";
		
		for(Model c: courses) {
			tableBody += insertCourse(c);
		}
		
		return tableBody;
	}
	
	private String insertCourse(Model c) {
		return "<tr>" +
					insertActions(c.getAttribute(Course.ID)) +
					insertCourseField(c.getAttribute(Course.NAME)) +
					insertCourseField(c.getAttribute(Course.LOCATION)) +
					insertCourseField(c.getAttribute(Course.TOTAL_SEATS)) +
					insertCourseField(c.getAttribute(Course.STARTING_DATE)) +
				"</tr>";
	}
	
	private String insertActions(String id) {
		return "<td>" 
					+ "<a href= \"course/delete/" + id +"\">" 
						+ "<i class=\"glyphicon glyphicon-trash\"></i>"
					+ "</a>"
					+ "<span>&nbsp;</span>"
					+ "<a href= \"course/" + id +"\">" 
						+ "<i class=\"glyphicon glyphicon-eye-open\"></i>"
					+ "</a>"
				+ "</td>";
	}
	
	private String insertCourseField(String field) {
		return "<td>" + field + "</td>";
	}
}
