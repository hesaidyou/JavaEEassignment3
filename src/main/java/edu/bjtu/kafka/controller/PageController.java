package edu.bjtu.kafka.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {

	
	@RequestMapping("/")
	public String welcomepage(Map<String, Object> map) {
		map.put("username", "xiaoming");
		return "/index";
	}
}
