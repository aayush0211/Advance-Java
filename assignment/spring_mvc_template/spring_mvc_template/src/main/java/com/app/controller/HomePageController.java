package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	public HomePageController()
	{
		System.out.println("In HomePageController Constr"+getClass());
	}
	//add req handling method to deliver the index page
	@RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("In show Home Page");
		return "/index";//Handler rets LVN --> D.S --> V.R --> AVN
		//WEB-INF/views/index.jsp
	}
}
