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

    private final static MyMEX mex = new MyMEX();

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

    //Dataset

    //Execution

    //Features

    //Sampling Method

    //Interface Version

    //Measures

}





