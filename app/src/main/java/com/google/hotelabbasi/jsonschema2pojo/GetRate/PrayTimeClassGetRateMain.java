package com.google.hotelabbasi.jsonschema2pojo.GetRate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.hotelabbasi.jsonschema2pojo.GetInfo.PrayTimeClassGetInfo;

public class PrayTimeClassGetRateMain {
    @SerializedName("data")
    @Expose
    private PrayTimeClassGetInfo data;
    @SerializedName("status")
    @Expose
    private String status;

    public PrayTimeClassGetInfo getData() {
        return data;
    }

    public void setData(PrayTimeClassGetInfo data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
