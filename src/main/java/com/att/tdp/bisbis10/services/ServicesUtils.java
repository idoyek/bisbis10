package com.att.tdp.bisbis10.services;

public class ServicesUtils {

    public static Double calculateAverageRating(Double averageRating, Integer ratingsListSize, Double newRating) {
        if (ratingsListSize == 0) {
            return newRating;
        } else {
            return (averageRating * ratingsListSize + newRating) / (ratingsListSize + 1);
        }
    }
}
