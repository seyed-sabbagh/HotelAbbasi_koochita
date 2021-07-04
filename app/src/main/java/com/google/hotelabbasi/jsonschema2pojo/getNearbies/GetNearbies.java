
package com.google.hotelabbasi.jsonschema2pojo.getNearbies;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetNearbies {

    @SerializedName("restaurant")
    @Expose
    private List<Object> restaurant = null;
    @SerializedName("hotel")
    @Expose
    private List<Hotel> hotel = null;

    public List<Object> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(List<Object> restaurant) {
        this.restaurant = restaurant;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

}
