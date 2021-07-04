
package com.google.hotelabbasi.jsonschema2pojo.getNearbies;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Hotel {

    @SerializedName("C")
    @Expose
    private Double c;
    @SerializedName("D")
    @Expose
    private Double d;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
