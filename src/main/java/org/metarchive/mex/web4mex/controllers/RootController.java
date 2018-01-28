package org.metarchive.mex.web4mex.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@GetMapping(value = { "/token" })
	public String createToken() {
		return UUID.randomUUID().toString();
	}

}
