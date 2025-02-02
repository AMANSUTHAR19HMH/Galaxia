package com.mazor.galaxia.ModelClass;

import com.google.gson.annotations.SerializedName;

public class Exoplanet {
    @SerializedName("pl_size")  // Added SerializedName if it should be serialized
    private final String size;

    @SerializedName("pl_name")
    private String name;

    @SerializedName("pl_masse")
    private double mass;

    @SerializedName("pl_rade")
    private double radius;

    @SerializedName("disc_year")
    private int discoveryYear;

    @SerializedName("hostname")
    private String hostStar;

    // Constructor with all parameters
    public Exoplanet(String name, String size, double mass, double radius, int discoveryYear, String hostStar) {
        this.name = name;
        this.size = size;
        this.mass = mass;
        this.radius = radius;
        this.discoveryYear = discoveryYear;
        this.hostStar = hostStar;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public int getDiscoveryYear() {
        return discoveryYear;
    }

    public String getHostStar() {
        return hostStar;
    }

    public String getSize() {
        return size;
    }
}
