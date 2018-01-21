package org.metarchive.mex.web4mex.controllers;

import java.text.DateFormat;
import java.text.ParseException;

import org.metarchive.mex.web4mex.services.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperimentController {

	@Autowired
	ExperimentService experimentService;

	
	@PostMapping(value = { "/{userId}/experimentId" })
	public void setExperimentId(@RequestBody String experimentId, @RequestParam String userId) {
		experimentService.getCacheByUser(userId).setExperimentId(experimentId);
	}	
	
	@PostMapping(value = { "/{userId}/experimentTitle" })
	public void setExperimentTitle(@RequestBody String experimentTitle, @RequestParam String userId) {
		experimentService.getCacheByUser(userId).setExperimentTitle(experimentTitle);
	}		
	
	@PostMapping(value = { "/{userId}/experimentDate" })
	public void setExperimentDate(@RequestBody String experimentDate, @RequestParam String userId) throws ParseException {
		experimentService.getCacheByUser(userId).setExperimentDate(DateFormat.getDateInstance().parse(experimentDate));
	}		
	
	@PostMapping(value = { "/{userId}/experimentDescription" })
	public void setExperimentDescription(@RequestBody String experimentDescription, @RequestParam String userId) throws ParseException {
		experimentService.getCacheByUser(userId).setExperimentDescription(experimentDescription);
	}		
	
	@PostMapping(value = { "/{userId}/experimentDataNormalizationDescription" })
	public void setExperimentDataNormalizationDescription(@RequestBody String experimentDataNormalizationDescription, @RequestParam String userId) throws ParseException {
		experimentService.getCacheByUser(userId).setExperimentDataNormalizationDescription(experimentDataNormalizationDescription);
	}		
	
	@PostMapping(value = { "/{userId}/experimentNoiseRemovalDescription" })
	public void setExperimentNoiseRemovalDescription(@RequestBody String experimentNoiseRemovalDescription, @RequestParam String userId) throws ParseException {
		experimentService.getCacheByUser(userId).setExperimentNoiseRemovalDescription(experimentNoiseRemovalDescription);
	}		
	
	@PostMapping(value = { "/{userId}/experimentAttributeSelectionDescription" })
	public void setExperimentAttributeSelectionDescription(@RequestBody String experimentAttributeSelectionDescription, @RequestParam String userId) throws ParseException {
		experimentService.getCacheByUser(userId).setExperimentAttributeSelectionDescription(experimentAttributeSelectionDescription);
	}		
	
	@PostMapping(value = { "/{userId}/experimentOutlierDetectionDescription" })
	public void setExperimentOutlierDetectionDescription(@RequestBody String experimentOutlierDetectionDescription, @RequestParam String userId) throws ParseException {
		experimentService.getCacheByUser(userId).setExperimentOutlierDetectionDescription(experimentOutlierDetectionDescription);
	}		
	
}
