package com.app.controller;

import com.app.view.Layout;

public class MainController implements Controller {
	public final static String ROUTE = "/";

	@Override
	public boolean handles(String route) {
		return route.equals(ROUTE);
	}

	@Override
	public void execute(Context context) throws Exception {
		context.response().setContentType("text/html");
		context.response().setCharacterEncoding("UTF-8");
		context.response().getWriter().write(new Layout().build().render());
	}
}
