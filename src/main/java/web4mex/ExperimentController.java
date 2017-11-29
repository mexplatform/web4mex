package web4mex;

import org.aksw.mex.interfaces.annotations.InterfaceVersion;
import org.aksw.mex.interfaces.annotations.Start;
import org.aksw.mex.interfaces.annotations.algo.Algorithm;
import org.aksw.mex.interfaces.annotations.core.*;
import org.aksw.mex.interfaces.annotations.perf.Measure;
import org.aksw.mex.log4mex.MEXSerializer;
import org.aksw.mex.log4mex.MyMEX;
import org.aksw.mex.util.MEXConstant;
import org.aksw.mex.util.MEXEnum;
import org.aksw.mex.log4mex.algo.AlgorithmVO;
import org.aksw.mex.log4mex.core.HardwareConfigurationVO;
import org.aksw.mex.log4mex.core.SamplingMethodVO;
import org.aksw.mex.util.MEXEnum;

import org.aksw.mex.log4mex.MyMEX;
import org.aksw.mex.log4mex.MEXSerializer;
import org.aksw.mex.interfaces.MetaGeneration;


import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;


@RestController
public class ExperimentController {



    public void saveIntoCache(String content, String filename) throws Exception{

        /* This method receives the input data comming from the user and saves into a text file on the cache folder */

        String path =  (System.getProperty("user.dir") + "/src/main/java/web4mex/cache");

        try(FileWriter file = new FileWriter((path + filename))){
            file.write(content);
        }

    }

    //Experiment Info
    @PostMapping(value = {"/experimentinfo"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setExperimentInfo(@RequestBody String content) throws Exception {

        String filename = "/experimentinfo.txt";

        this.saveIntoCache(content, filename);

    }



    // Hardware Info
    @PostMapping(value = {"/hardwareinfo"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setHardwareInfo(@RequestBody String content) throws Exception {

        String filename = "/hardwareinfo.txt";

        this.saveIntoCache(content, filename);

    }

    //Algorithm
    @PostMapping(value = {"/algorithm"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setAlgorithmInfo(@RequestBody String content) throws Exception {

        String filename = "/algorithm.txt";

        this.saveIntoCache(content, filename);

    }

    //Dataset
    @PostMapping(value = {"/datasetinfo"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setDatasetInfo(@RequestBody String content) throws Exception {

        String filename = "/dataset.txt";

        this.saveIntoCache(content, filename);

    }


    //Executions
    @PostMapping(value = {"/executions"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setExecutions(@RequestBody String content) throws Exception {

        String filename = "/executions.txt";

        this.saveIntoCache(content, filename);

    }

    //Features
    @PostMapping(value = {"/features"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setFeatures(@RequestBody String content) throws Exception {

        String filename = "/features.txt";

        this.saveIntoCache(content, filename);

    }

    //Sampling Method
    @PostMapping(value = {"/samplingmethod"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setSamplingMethod(@RequestBody String content) throws Exception {

        String filename = "/samplingmethod.txt";

        this.saveIntoCache(content, filename);

    }

    //Interface Version
    @PostMapping(value = {"/interfaceversion"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setInterfaceVersion(@RequestBody String content) throws Exception {

        String filename = "/interfaceversion.txt";

        this.saveIntoCache(content, filename);

    }

    //Measures
    @PostMapping(value = {"/measures"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public void setMeasures(@RequestBody String content) throws Exception {

        String filename = "/measures.txt";

        this.saveIntoCache(content, filename);

    }

    @PostMapping(value = {"/start"})
    public void start() throws  Exception{
        JSONParser parser = new JSONParser();

        MyMEX mex = new MyMEX();

        String path =  (System.getProperty("user.dir") + "/src/main/java/web4mex/cache");

        //Experiment Info

        Object experimentInfo = parser.parse(new FileReader(path + "/experimentinfo.txt"));
        JSONObject jsonExperimentInfo = (JSONObject) experimentInfo;

        String experimentId = (String) jsonExperimentInfo.get("id"); // Cast long to string ???
        String experimentTitle = (String) jsonExperimentInfo.get("title");
        String experimentDescription = (String) jsonExperimentInfo.get("description");
        String authorEmail= (String) jsonExperimentInfo.get("email");
        String authorName = (String) jsonExperimentInfo.get("author");
        //Date experimentDate = (Date) jsonExperimentInfo.get("date");
        MEXEnum.EnumContexts context = MEXEnum.EnumContexts.valueOf((String) jsonExperimentInfo.get("context")); //Change to String on Log4MEX

        mex.setExperimentId(experimentId);
        mex.setExperimentTitle(experimentTitle);
        mex.setExperimentDescription(experimentDescription);
        mex.setAuthorEmail(authorEmail);
        mex.setAuthorName(authorName);
        //mex.setExperimentDate(experimentDate);
        mex.setContext(context);

        //Experiment


        MEXSerializer.getInstance().saveToDisk(path + "/experiment",path + "/experiment", mex, MEXConstant.EnumRDFFormats.TTL);


    }

}





