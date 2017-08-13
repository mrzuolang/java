package com.zl.rest.pub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginRest {
	@RequestMapping(value="/login",method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name", required = false) String name)
    {
        return "hello";
    }
}
