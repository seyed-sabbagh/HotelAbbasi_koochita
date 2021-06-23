package com.google.hotelabbasi.jsonschema2pojo.GetInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class PrayTimeClassGetInfoMain {
    @SerializedName("detail")
    @Expose
    private PrayTimeClassGetInfo detail;
    @SerializedName("status")
    @Expose
    private String status;

    public PrayTimeClassGetInfo getDetail() {
        return detail;
    }

    public void setDetail(PrayTimeClassGetInfo detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
