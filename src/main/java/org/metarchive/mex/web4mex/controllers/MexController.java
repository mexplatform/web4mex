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

	@PostMapping(value = { "/{userId}/authorName" })
	public void setAuthorName(@RequestBody String authorName, @RequestParam String userId) {
		experimentService.getCacheByUser(userId).setAuthorName(authorName);
	}

	@PostMapping(value = { "/{userId}/authorEmail" })
	public void setAuthorEmail(@RequestBody String authorEmail, @RequestParam String userId) {
		experimentService.getCacheByUser(userId).setAuthorEmail(authorEmail);
	}

	@PostMapping(value = { "/{userId}/context" })
	public void setContext(@RequestBody MEXEnum.EnumContexts context, @RequestParam String userId) {
		experimentService.getCacheByUser(userId).setContext(context);
	}

	@PostMapping(value = { "/{userId}/organization" })
	public void setOrganization(@RequestBody String organization, @RequestParam String userId) {
		experimentService.getCacheByUser(userId).setOrganization(organization);
	}

	@GetMapping(value = { "/{userId}/serialize?format={serializationFormat}" })
	public @ResponseBody String serialize(@RequestParam String userId, @RequestParam String serializationFormat)
			throws Exception {
		return experimentService.serializeExperiment(userId, serializationFormat);
	}

}
