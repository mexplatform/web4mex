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
import org.springframework.stereotype.Service;

@Service

public class ExperimentService {

	HashMap<String, MyMEX> cache = new HashMap<>();

	public MyMEX getCacheByUser(String userId) {
		if (cache.get(userId) == null)
			cache.put(userId, new MyMEX());

		return cache.get(userId);
	}

	public String serializeExperiment(String userId, String serializationFormat) throws Exception {
		
		String fileName = "/tmp/mex_" + userId;

		serializeAndSave(userId, serializationFormat, fileName);
		String rdf = readFile(fileName).toString();
		deleteFile(fileName);

		return rdf;
	}
	
	protected void serializeAndSave(String userId, String serializationFormat, String fileName) throws Exception {
		

		// TODO Create a serialization method that doesn't require to use filesystem.
		MEXSerializer.getInstance().saveToDisk(fileName, "http://metarchive.org/mex/experiments/" + userId,
				getCacheByUser(userId), MEXConstant.EnumRDFFormats.valueOf(serializationFormat));
		
	}

	protected StringBuffer readFile(String fileName) throws IOException {
		
		StringBuffer rdf = new StringBuffer();
		try (BufferedReader r = Files.newBufferedReader(Paths.get(fileName))) {
			r.lines().forEach((a) -> {
				rdf.append(a);
			});
		}
		
		return rdf;
	}
	
	protected void deleteFile(String fileName) {
		new File(fileName).delete();
	}
	
	
}
