package org.metarchive.mex.web4mex.objects;

import org.metarchive.mex.core.MEXEnum;

public class Hardware {
    private MEXEnum.EnumProcessors cpu;
    private MEXEnum.EnumRAM memory;
    private String hd;
    private MEXEnum.EnumCaches cache;
    private String os;
    private String video;

    public MEXEnum.EnumProcessors getCpu() {
        return cpu;
    }

    public void setCpu(MEXEnum.EnumProcessors cpu) {
        this.cpu = cpu;
    }

    public MEXEnum.EnumRAM getMemory() {
        return memory;
    }

    public void setMemory(MEXEnum.EnumRAM memory) {
        this.memory = memory;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public MEXEnum.EnumCaches getCache() {
        return cache;
    }

    public void setCache(MEXEnum.EnumCaches cache) {
        this.cache = cache;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
