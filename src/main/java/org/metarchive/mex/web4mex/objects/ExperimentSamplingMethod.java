package org.metarchive.mex.web4mex.objects;

import org.metarchive.mex.core.MEXEnum;

public class ExperimentSamplingMethod {
    MEXEnum.EnumSamplingMethods aSM;
    double trainSize;
    double testSize;
    //int folds;
    //boolean sequential;


    public MEXEnum.EnumSamplingMethods getaSM() {
        return aSM;
    }

    public void setaSM(MEXEnum.EnumSamplingMethods aSM) {
        this.aSM = aSM;
    }

    public double getTrainSize() {
        return trainSize;
    }

    public void setTrainSize(double trainSize) {
        this.trainSize = trainSize;
    }

    public double getTestSize() {
        return testSize;
    }

    public void setTestSize(double testSize) {
        this.testSize = testSize;
    }
}
