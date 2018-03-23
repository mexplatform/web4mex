package org.metarchive.mex.web4mex.controllers;

import org.metarchive.mex.web4mex.objects.*;
import org.metarchive.mex.log4mex.ExperimentConfigurationVO;

import java.text.DateFormat;
import java.text.ParseException;
import java.net.URI;

import org.metarchive.mex.web4mex.services.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.metarchive.mex.core.MEXEnum;

@RestController
public class ExperimentController {

	@Autowired
	ExperimentService experimentService;

	
	@PostMapping(value = { "/{token}/experimentId" })
	public void setExperimentId(@RequestBody String experimentId, @PathVariable String token) {
		experimentService.getCacheByUser(token).setExperimentId(experimentId);
	}	
	
	@PostMapping(value = { "/{token}/experimentTitle" })
	public void setExperimentTitle(@RequestBody String experimentTitle, @PathVariable String token) {
		experimentService.getCacheByUser(token).setExperimentTitle(experimentTitle);
	}		
	
	@PostMapping(value = { "/{token}/experimentDate" })
	public void setExperimentDate(@RequestBody String experimentDate, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentDate(DateFormat.getDateInstance().parse(experimentDate));
	}		
	
	@PostMapping(value = { "/{token}/experimentDescription" })
	public void setExperimentDescription(@RequestBody String experimentDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentDescription(experimentDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentDataNormalizationDescription" })
	public void setExperimentDataNormalizationDescription(@RequestBody String experimentDataNormalizationDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentDataNormalizationDescription(experimentDataNormalizationDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentNoiseRemovalDescription" })
	public void setExperimentNoiseRemovalDescription(@RequestBody String experimentNoiseRemovalDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentNoiseRemovalDescription(experimentNoiseRemovalDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentAttributeSelectionDescription" })
	public void setExperimentAttributeSelectionDescription(@RequestBody String experimentAttributeSelectionDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentAttributeSelectionDescription(experimentAttributeSelectionDescription);
	}		
	
	@PostMapping(value = { "/{token}/experimentOutlierDetectionDescription" })
	public void setExperimentOutlierDetectionDescription(@RequestBody String experimentOutlierDetectionDescription, @PathVariable String token) throws ParseException {
		experimentService.getCacheByUser(token).setExperimentOutlierDetectionDescription(experimentOutlierDetectionDescription);
	}

	@PostMapping(value = { "/{token}/experimentAlgorithm" })
	public void setExperimentAlgorithm(@RequestBody Algorithm experimentAlgorithm, @PathVariable String token) throws Exception {
        String algorithmID = experimentAlgorithm.getAlgorithmID();
        MEXEnum.EnumAlgorithmsClasses algorithmClass = experimentAlgorithm.getAlgorithmClass();
        MEXEnum.EnumExecutionsType executionType = experimentAlgorithm.getExecutionType();
        MEXEnum.EnumPhases phase = experimentAlgorithm.getPhase();
        MEXEnum.EnumMeasures measure = experimentAlgorithm.getMeasure();
        Double measureValue = experimentAlgorithm.getMeasureValue();

        String algo = experimentService.getCacheByUser(token).Configuration().addAlgorithm(algorithmID, algorithmClass);
        String id = experimentService.getCacheByUser(token).Configuration().addExecution(executionType, phase);
        experimentService.getCacheByUser(token).Configuration().Execution(id).setAlgorithm(algo);
        experimentService.getCacheByUser(token).Configuration().Execution(id).addPerformance(measure, measureValue);
	}

    @PostMapping(value = { "/{token}/experimentDataset" })
    public void setExperimentDataset(@RequestBody Dataset experimentDataset, @PathVariable String token) throws Exception {
        String name = experimentDataset.getName();
        String URI = experimentDataset.getURI();
        String description = experimentDataset.getDescription();
        experimentService.getCacheByUser(token).Configuration().setDataSet(URI, description, name);
    }

    @PostMapping(value = { "/{token}/experimentHardware" })
    public void setExperimentHardware(@RequestBody Hardware experimentHardware, @PathVariable String token) throws Exception {
        MEXEnum.EnumProcessors cpu = experimentHardware.getCpu();
        MEXEnum.EnumRAM memory = experimentHardware.getMemory();
        String hd = experimentHardware.getHd();
        MEXEnum.EnumCaches cache = experimentHardware.getCache();
        String os = experimentHardware.getOs();
        String video = experimentHardware.getVideo();

        experimentService.getCacheByUser(token).Configuration().setHardwareConfiguration(os, cpu, memory, hd, cache);
    }

    @PostMapping(value = {"/{token}/experimentSamplingMethod"})
    public void setSamplingMethod(@RequestBody ExperimentSamplingMethod experimentSamplingMethod, @PathVariable String token) throws Exception {
        MEXEnum.EnumSamplingMethods SM = experimentSamplingMethod.getaSM();
	    double trainSize = experimentSamplingMethod.getTrainSize();
	    double testSize = experimentSamplingMethod.getTestSize();
	    //int folds = experimentSamplingMethod.getFolds();
	    //boolean sequential = experimentSamplingMethod.isSequential();

	    experimentService.getCacheByUser(token).Configuration().setSamplingMethod(SM, trainSize, testSize);
        //experimentService.getCacheByUser(token).Configuration().SamplingMethod().setFolds(folds);
        //experimentService.getCacheByUser(token).Configuration().SamplingMethod().setSequential(sequential);
        //experimentService.getCacheByUser(token).Configuration().SamplingMethod()

    }



}
