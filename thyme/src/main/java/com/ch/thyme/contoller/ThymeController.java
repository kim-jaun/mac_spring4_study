package com.ch.thyme.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}