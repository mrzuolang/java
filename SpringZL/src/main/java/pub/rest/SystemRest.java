package pub.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemRest {

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name", required = false) String name) {
		return "version:0.1.1";
	}

	@RequestMapping(value = "/name", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestBody String json) {
		return "spring+mybatis+gradle";
	}
}
