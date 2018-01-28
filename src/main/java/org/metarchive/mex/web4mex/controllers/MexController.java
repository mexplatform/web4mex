package org.metarchive.mex.web4mex.controllers;

import org.metarchive.mex.core.MEXEnum;
import org.metarchive.mex.web4mex.services.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
public class MexController {

	@Autowired
	ExperimentService experimentService;

	@PostMapping(value = { "/{token}/authorName" })
	public void setAuthorName(@RequestBody String authorName, @PathVariable String token) {
		experimentService.getCacheByUser(token).setAuthorName(authorName);
	}

	@PostMapping(value = { "/{token}/authorEmail" })
	public void setAuthorEmail(@RequestBody String authorEmail, @PathVariable String token) {
		experimentService.getCacheByUser(token).setAuthorEmail(authorEmail);
	}

    @PostMapping(value = { "/{token}/context" })
    public void setContext(@RequestBody String context, @PathVariable String token) {
        experimentService.getCacheByUser(token).setContext(MEXEnum.EnumContexts.valueOf(context));
    }

	@PostMapping(value = { "/{token}/organization" })
	public void setOrganization(@RequestBody String organization, @PathVariable String token) {
		experimentService.getCacheByUser(token).setOrganization(organization);
	}

	@GetMapping(value = { "/{token}/serialize" }, produces = MediaType.TEXT_PLAIN)
	public @ResponseBody String serialize(@PathVariable String token, @RequestParam String format)
			throws Exception {
		return experimentService.serializeExperiment(token, format);
	}

}
