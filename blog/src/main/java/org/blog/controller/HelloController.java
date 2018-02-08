package org.blog.controller;
import org.blog.service.RedisMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("hello")
public class HelloController {
	@Autowired
    private RedisMap map;
	
	@RequestMapping(value="sayHello")
	public String sayHello() {
		return "Hi hello .";
	}
	@RequestMapping(value="say")
	public String say(@RequestParam String name) {
		return name+" Hello!";
	}
	
	@GetMapping("/insert")
	public String insert(@RequestParam String hello ) {
		
		return hello;
	}
	@GetMapping("/save")
	public String save(String hello,String name ) {
		
		return hello+name;
	}
	@GetMapping("/redis")
	public String redis(String hello) {
		String name = map.getValue("name");
		if(name==null) {
			map.setKey("name", hello);
			return "";
		}else {
			map.setKey("name", "hello,"+hello);
			return name;
		}
	}
}
