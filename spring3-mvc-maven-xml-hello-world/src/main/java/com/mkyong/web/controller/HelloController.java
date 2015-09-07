package com.mkyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.web.model.Employee;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	
	
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}
	
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String  showForm(Model model,@RequestParam(value="message",required=false)  String msg) {

		Employee e=new Employee();
		if(msg==null)
		e.setName("SPRING TUTORIALS");
		else
			e.setName(msg);
		model.addAttribute("myEmployee",e);
		return "ViewForm";

	}

}