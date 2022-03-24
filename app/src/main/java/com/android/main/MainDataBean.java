package com.android.main;

import com.llj.baselib.IOTInterfaceId;

public class MainDataBean {

    @IOTInterfaceId("14770")
    private Float temp;

    private Float humi;

    private Float windDegree;

    private Float lightDegree;

    private Float coveredAndRained;

    public Float getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "MainDataBean{" +
                "temp=" + temp +
                ", humi=" + humi +
                ", windDegree=" + windDegree +
                ", lightDegree=" + lightDegree +
                ", coveredAndRained=" + coveredAndRained +
                '}';
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getHumi() {
        return humi;
    }

    public void setHumi(Float humi) {
        this.humi = humi;
    }

    public Float getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Float windDegree) {
        this.windDegree = windDegree;
    }

    public Float getLightDegree() {
        return lightDegree;
    }

    public void setLightDegree(Float lightDegree) {
        this.lightDegree = lightDegree;
    }

    public Float getCoveredAndRained() {
        return coveredAndRained;
    }

    public void setCoveredAndRained(Float coveredAndRained) {
        this.coveredAndRained = coveredAndRained;
    }
}
