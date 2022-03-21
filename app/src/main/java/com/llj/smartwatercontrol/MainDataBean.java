package com.llj.smartwatercontrol;

import com.llj.baselib.IOTInterfaceId;

public class MainDataBean {

    @IOTInterfaceId("14770")
    private Float data;

    public Float getData() {
        return data;
    }

    public void setData(Float data) {
        this.data = data;
    }
}
