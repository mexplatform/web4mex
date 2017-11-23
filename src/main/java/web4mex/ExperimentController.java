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



import java.util.concurrent.atomic.AtomicLong;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExperimentController {

    private final static MyMEX mex = new MyMEX();

    @PostMapping(value = {"/experimentinfo"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public String setExperimentInfo(@RequestBody String content) throws ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(content);   //content);
        JSONObject jsonObject = (JSONObject) obj;


        System.out.println(content);

        return "";
    }

    @PostMapping(value = {"/hardwareinfo"}, consumes = {"text/plain", "application/json"}, produces = {"text/plain", "application/json"})
    public String setHardwareInfo(@RequestBody String content){

        System.out.println(content);

        return "";
    }

}





