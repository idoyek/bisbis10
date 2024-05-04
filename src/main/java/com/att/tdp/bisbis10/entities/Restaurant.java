package com.att.tdp.bisbis10.entities;

import com.att.tdp.bisbis10.entities.converters.StringListConverter;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    private Double average_rating;
    private Boolean is_kosher;

    @Convert(converter = StringListConverter.class)
    private List<String> cuisines;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAverage_rating() {
        return average_rating;
    }

    public Boolean getIs_kosher() {
        return is_kosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }
}
