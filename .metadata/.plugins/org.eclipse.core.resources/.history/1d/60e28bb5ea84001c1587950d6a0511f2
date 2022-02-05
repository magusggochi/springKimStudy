package hello.hellospring.controller;

import java.util.LinkedHashMap;

import org.apache.catalina.util.ParameterMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("hello")
	public String hello(Model model) {
		
		System.out.println("/hello start");
		model.addAttribute("data", "hello!!");
		return"hello";
	}
	
	@GetMapping("/hello-mvc")
	public String helloMvc(@RequestParam(required = false, value = "name") String name, Model model) {
		model.addAttribute("name", name);
		
		return "hello-template";
	}
	
	@GetMapping("/hello-string")
	@ResponseBody
	public ParameterMap<Object, Object> helloString(@RequestParam(required = false, value = "name") String name) {
		
		ParameterMap<Object, Object> param = new ParameterMap<Object, Object>();
		
		param.put("name", "magu");
		param.put("age", 19);
	
		return param;
	}
	
	@GetMapping("/hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam(required = false, value = "name") String name) {
		
		Hello hello = new Hello();
	
		hello.setName("¸¶±¸");
		
		return hello;
	}
	
	
	static class Hello {
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
}
