package com.zl.rest.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zl.dao.pub.UserMapper;

/**
 * Created by elili on 5/19/2016.
 */
@RestController
@RequestMapping ("/test" )
public class HelloRest {
	@Autowired
	private UserMapper dao;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name", required = false) String name) {
		return "hello world";
	}

	@RequestMapping(value = "/person/login", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String json) {
		return json;
	}
}
