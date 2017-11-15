package com;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.CourseController;
import com.app.controller.MainController;
import com.app.controller.StudentController;

public class ControllerFactory {

	public List<Controller> create() {
		return new ArrayList<>(asList(
				new MainController(),
				new CourseController(),
				new StudentController()));
	}
}
