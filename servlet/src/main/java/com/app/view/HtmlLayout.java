package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.*;

import com.github.manliogit.javatags.element.Element;

public class HtmlLayout {
private final String content;
	
	public HtmlLayout(String content) {
		this.content = content;
	}
	
	public String render() {
		return content;
				
	}
}
