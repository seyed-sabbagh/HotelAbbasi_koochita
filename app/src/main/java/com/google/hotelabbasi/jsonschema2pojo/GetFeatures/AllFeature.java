
package com.google.hotelabbasi.jsonschema2pojo.GetFeatures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class AllFeature {

    @SerializedName("features")
    @Expose
    private List<Feature> features = null;
    @SerializedName("name")
    @Expose
    private String name;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
