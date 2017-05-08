package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by elili on 5/19/2016.
 */
@RestController
public class HelloRest
{
 

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name)
    {
        return "hello world";
    }
}
