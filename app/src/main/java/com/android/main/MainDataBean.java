package com.android.main;

import com.llj.baselib.IOTInterfaceId;

public class MainDataBean {

    @IOTInterfaceId("22818")
    private Float temp;

    @IOTInterfaceId("22720")
    private Float humi;

    @IOTInterfaceId("22727")
    private Float windDegree;

    @IOTInterfaceId("22724")
    private Float lightDegree;

    @IOTInterfaceId("22725")
    private int covered;

    @IOTInterfaceId("22726")
    private Float rained;

    public Float getTemp() {
        return temp;
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

    public Integer getCovered() {
        return covered;
    }

    public void setCovered(Integer covered) {
        this.covered = covered;
    }

    public Float getRained() {
        return rained;
    }

    public void setRained(Float rained) {
        this.rained = rained;
    }

    @Override
    public String toString() {
        return "MainDataBean{" +
                "temp=" + temp +
                ", humi=" + humi +
                ", windDegree=" + windDegree +
                ", lightDegree=" + lightDegree +
                ", covered=" + covered +
                ", rained=" + rained +
                '}';
    }
}
