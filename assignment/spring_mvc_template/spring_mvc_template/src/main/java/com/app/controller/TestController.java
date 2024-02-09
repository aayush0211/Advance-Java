package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//mandatory cls level anno to specify: clas => req handling controller(=Handler) , singleton0
public class TestController {

	public TestController()
	{
		System.out.println("in ctor of "+ getClass());
	}
	//add rq handling method to display welcome mesg to clnt
	@RequestMapping("/test1")//=>service
	//Mandatory method level anno -- can intercept ANY HTTP req(get/post
	//handlerMapping bean, key :/test1
	//value : com.app.controller.TestController.testMe1
	public String testMe1()
	{
		System.out.println("in testme1");
		return "/display";//AVN: /WEB-INF/views/display.jsp(Handler --> AVN -->DS
	}
}
