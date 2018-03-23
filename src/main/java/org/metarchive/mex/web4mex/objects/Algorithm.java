package org.metarchive.mex.web4mex.objects;

import org.metarchive.mex.core.MEXEnum;

public class Algorithm {
    private String algorithmID;
    private MEXEnum.EnumAlgorithmsClasses algorithmClass;
    private MEXEnum.EnumExecutionsType executionType;
    private MEXEnum.EnumPhases phase;
    private MEXEnum.EnumMeasures measure;
    private Double measureValue;

    public String getAlgorithmID() {
        return algorithmID;
    }

    public void setAlgorithmID(String algorithmID) {
        this.algorithmID = algorithmID;
    }

    public MEXEnum.EnumAlgorithmsClasses getAlgorithmClass() {
        return algorithmClass;
    }

    public void setAlgorithmClass(MEXEnum.EnumAlgorithmsClasses algorithmClass) {
        this.algorithmClass = algorithmClass;
    }

    public MEXEnum.EnumExecutionsType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(MEXEnum.EnumExecutionsType executionType) {
        this.executionType = executionType;
    }

    public MEXEnum.EnumPhases getPhase() {
        return phase;
    }

    public void setPhase(MEXEnum.EnumPhases phase) {
        this.phase = phase;
    }

    public MEXEnum.EnumMeasures getMeasure() {
        return measure;
    }

    public void setMeasure(MEXEnum.EnumMeasures measure) {
        this.measure = measure;
    }

    public Double getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(Double measureValue) {
        this.measureValue = measureValue;
    }
}
