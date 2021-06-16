
package com.google.hotelabbasi.jsonschema2pojo.GetFeatures;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrayTimeClassGetFeatures {

    @SerializedName("allFeatures")
    @Expose
    private List<AllFeature> allFeatures = null;
    @SerializedName("status")
    @Expose
    private String status;

    public List<AllFeature> getAllFeatures() {
        return allFeatures;
    }

    public void setAllFeatures(List<AllFeature> allFeatures) {
        this.allFeatures = allFeatures;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
