package com.ff4j.rest;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
    private FF4j ff4j;
	
	@RequestMapping(value="/hello")
	public String sayHello() {
		if (ff4j.check("sayHelloAPI")) {
			return "Hello!";
		}
		return "Feature is currently disabled.";
	}
	
	@RequestMapping(value="/hourfeature")
	public String hourFeature() {
		if (ff4j.check("hourFeatureTest")) {
			return "Hello!";
		}
		return "Feature is currently disabled.";
	}
	
	@RequestMapping(value="release")
	public String release() {
		if (ff4j.check("futureReleaseDate")) {
			return "Feature released!";
		}
		return "Feature not yet released";
	}
}
