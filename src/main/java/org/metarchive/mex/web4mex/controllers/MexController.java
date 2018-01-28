package org.metarchive.mex.web4mex.controllers;

import org.metarchive.mex.core.MEXEnum;
import org.metarchive.mex.web4mex.services.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MexController {

	@Autowired
	ExperimentService experimentService;

	@PostMapping(value = { "/{token}/authorName" })
	public void setAuthorName(@RequestBody String authorName, @RequestParam String token) {
		experimentService.getCacheByUser(token).setAuthorName(authorName);
	}

	@PostMapping(value = { "/{token}/authorEmail" })
	public void setAuthorEmail(@RequestBody String authorEmail, @RequestParam String token) {
		experimentService.getCacheByUser(token).setAuthorEmail(authorEmail);
	}

	@PostMapping(value = { "/{token}/context" })
	public void setContext(@RequestBody MEXEnum.EnumContexts context, @RequestParam String token) {
		experimentService.getCacheByUser(token).setContext(context);
	}

	@PostMapping(value = { "/{token}/organization" })
	public void setOrganization(@RequestBody String organization, @RequestParam String token) {
		experimentService.getCacheByUser(token).setOrganization(organization);
	}

	@GetMapping(value = { "/{token}/serialize?format={serializationFormat}" })
	public @ResponseBody String serialize(@RequestParam String token, @RequestParam String serializationFormat)
			throws Exception {
		return experimentService.serializeExperiment(token, serializationFormat);
	}

}
