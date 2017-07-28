package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.s4",method=RequestMethod.GET)
	public ModelAndView loginHome(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	{
		return new ModelAndView("");
	}
	
	@RequestMapping(value="/login.s4",method=RequestMethod.POST,params={"signIn"})
	public ModelAndView signIn(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	{
		//## redirected to user home screen if sign in successful.
		return new ModelAndView("");
	}
	@RequestMapping(value="/login.s4",method=RequestMethod.POST,params={"signUp"})
	public ModelAndView signUp(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	{
		//##redirected to user new home screen after successful sign up.
		return new ModelAndView("");
	}

}
