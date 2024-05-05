package com.att.tdp.bisbis10.services;

import java.util.UUID;

public class ServicesUtils {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
