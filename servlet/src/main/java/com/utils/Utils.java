package com.utils;

import com.app.controller.Context;

public class Utils {
	public final static String POST_METHOD = "POST";
	
	public static int extractIdFromContext(Context context) {
		String url = context.request().getRequestURL().toString();
		String[] split = url.split("/");
		return Integer.parseInt(split[split.length-1]);
	}
	
	public static boolean isPostRequest(Context context) {
		return context.request().getMethod().equals(POST_METHOD);
	}
}
