package org.metarchive.mex.web4mex.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.metarchive.mex.core.MEXConstant;
import org.metarchive.mex.log4mex.MEXSerializer;
import org.metarchive.mex.log4mex.MyMEX;
import org.metarchive.mex.web4mex.Web4MexProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperimentService {

    @Autowired
    Web4MexProperties web4MexProperties;

    HashMap<String, MyMEX> cache = new HashMap<>();

    public MyMEX getCacheByUser(String token) {
        if (cache.get(token) == null)
            cache.put(token, new MyMEX());

        return cache.get(token);
    }

    public String serializeExperiment(String userId, String serializationFormat) throws Exception {

        String fileName = web4MexProperties.getTmpDir() + "/mex_" + userId;

        new File(web4MexProperties.getTmpDir()).mkdirs();

        serializeAndSave(userId, serializationFormat, fileName);
        String rdf = readFile(fileName + "." + serializationFormat.toLowerCase()).toString();
        deleteFile(fileName + "." + serializationFormat.toLowerCase());

        return rdf;
    }

    protected void serializeAndSave(String userId, String serializationFormat, String fileName) throws Exception {

        // TODO Create a serialization method that doesn't require to use filesystem.
        MEXSerializer.getInstance().saveToDisk(fileName, web4MexProperties.getUriBase() + userId,
                getCacheByUser(userId), MEXConstant.EnumRDFFormats.valueOf(serializationFormat.toUpperCase()));

    }

    protected StringBuffer readFile(String fileName) throws IOException {

        StringBuffer rdf = new StringBuffer();
        try (BufferedReader r = Files.newBufferedReader(Paths.get(fileName))) {
            r.lines().forEach((a) -> {
                rdf.append(a);
                rdf.append("\n");
            });
        }

        return rdf;
    }

    protected void deleteFile(String fileName) {
        new File(fileName).delete();
    }

}
