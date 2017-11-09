package com.app.view;

import static com.github.manliogit.javatags.lang.HtmlHelper.a;
import static com.github.manliogit.javatags.lang.HtmlHelper.attr;
import static com.github.manliogit.javatags.lang.HtmlHelper.body;
import static com.github.manliogit.javatags.lang.HtmlHelper.div;
import static com.github.manliogit.javatags.lang.HtmlHelper.h1;
import static com.github.manliogit.javatags.lang.HtmlHelper.head;
import static com.github.manliogit.javatags.lang.HtmlHelper.html5;
import static com.github.manliogit.javatags.lang.HtmlHelper.link;
import static com.github.manliogit.javatags.lang.HtmlHelper.meta;
import static com.github.manliogit.javatags.lang.HtmlHelper.p;
import static com.github.manliogit.javatags.lang.HtmlHelper.text;
import static com.github.manliogit.javatags.lang.HtmlHelper.title;

import com.github.manliogit.javatags.element.Element;

public class RawLayout {
	private final String content;
	
	public RawLayout(String content) {
		this.content = content;
	}
	
	public Element build() {
		return html5(
		        	head(
				          meta(attr("charset -> utf-8")),
				          meta(attr("http-equiv -> X-UA-Compatible","content -> IE=edge")),
				          meta(attr("name -> viewport","content -> width=device-width, initial-scale=1")),
				          title(
				            "Raw course"
				          ),
				          text("<!-- Bootstrap core CSS -->"),
				          link(attr("href -> css/bootstrap.min.css","rel -> stylesheet"))
				        ),
				        body(
				          div(attr("class -> container"),
				            div(attr("class -> jumbotron"),
				              h1(
				                "Raw course"
				              ),
				              p(attr("class -> lead"),
				                text(content)
				              )
				            )
				          )
				        )
				      );
	}
}
