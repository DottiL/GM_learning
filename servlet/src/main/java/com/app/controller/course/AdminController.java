package com.app.controller.course;

import com.Servlet;
import com.app.controller.Context;
import com.app.controller.Controller;
import com.app.view.course.AdminLayout;

public class AdminController implements Controller {
	public final static String ROUTE = "/course";

	@Override
	public boolean handles(String route) {
		return AdminController.ROUTE.equals(route);
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");

		context.response().getWriter().write(new AdminLayout(Servlet.courses).render());
	}

}
