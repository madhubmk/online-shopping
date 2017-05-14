package com.poc.springmvcangular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to SpringMVC");
		
		return mv;
	}
	
	@RequestMapping(value = "/test")
	public ModelAndView testRequestParam(@RequestParam(value="greeting", required=false)String greeting){
		
		if(greeting == null)
			greeting = "Hello Query param is missing ;)";
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv; 
	}
	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView testPathVariable(@PathVariable(value="greeting", required=false)String greeting){
		
		if(greeting == null)
			greeting = "Hello Query param is missing ;)";
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv; 
	}
}
