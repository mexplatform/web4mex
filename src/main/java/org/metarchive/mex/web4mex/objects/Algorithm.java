package org.metarchive.mex.web4mex.objects;

import org.metarchive.mex.core.MEXEnum;

public class Algorithm {
    private String algorithmID;private String algorithmName;
    private String URL;
    private String algorithmClass;
    private String idExecution;

    public String getAlgorithmID() {
        return algorithmID;
    }

    public void setAlgorithmID(String algorithmID) {
        this.algorithmID = algorithmID;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getAlgorithmClass() {
        return algorithmClass;
    }

    public void setAlgorithmClass(String algorithmClass) {
        this.algorithmClass = algorithmClass;
    }

    public String getIdExecution() {
        return idExecution;
    }

    public void setIdExecution(String idExecution) {
        this.idExecution = idExecution;
    }


}
