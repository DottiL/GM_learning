package com;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import com.app.controller.Controller;
import com.app.controller.CsvController;
import com.app.controller.course.AdminController;
import com.app.controller.course.CreateController;

public class ControllerFactory {

	public List<Controller> create() {
		return new ArrayList<>(asList(
				new CsvController(), 
				new CreateController(), 
				new AdminController()));
	}
}
