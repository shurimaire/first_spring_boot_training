package com.awesome.api.name;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NameController {
	
	@Value("${name}")
	private String name;
	
	@GetMapping(value="/name")
	public String name() {
		return "this is " + name;
	}

}
