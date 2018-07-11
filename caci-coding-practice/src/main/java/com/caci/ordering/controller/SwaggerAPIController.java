package com.caci.ordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;


@Api( description = "Swagger API Controller")
@Controller
@RequestMapping("/")
public class SwaggerAPIController {
	@RequestMapping(method = RequestMethod.GET)
	public String getDocs() {
		return "redirect:swagger-ui.html";
	}
}
