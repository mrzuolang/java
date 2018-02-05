package org.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("Hello")
public class HelloController {
	@RequestMapping(value="sayHello")
	public String sayHello() {
		return "Hi hello .";
	}
}
