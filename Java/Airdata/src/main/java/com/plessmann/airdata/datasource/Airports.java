/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.datasource;

import com.plessmann.airdata.models.Airport;
import com.plessmann.airdata.models.Country;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Plesse
 */
public class Airports {
    
    protected static Airports me = null;
    
    private final List<Airport> airports;

    public Airports() {
        airports = new ArrayList<>();
    }
    
    public static synchronized Airports getInstance() {
        if(me == null){
            me = new Airports();
        }
        return me;
    }
    
    public void addAirport(Airport airport) {
        airports.add(airport);
    }
    
    public List<Airport> getByCountry(String code) {
        return airports.stream().filter(airport -> airport.getIsoCountry().equals(code)).collect(Collectors.toList());
    }

    public List<Map.Entry<String, Long>> surface(Country country) {
        Map<String, Long> result = new HashMap<>();
        List<Airport> countryAirports = getByCountry(country.getCode());
        countryAirports.forEach(airport -> Runways.getInstance().getSurface(airport).forEach((k, v) -> result.merge(k, v, Long::sum)));
        return result.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).collect(Collectors.toList());
    }
    
    public int qtyByCountry(Country country) {
        return getByCountry(country.getCode()).size();
    }
    
    public int count() {
        return airports.size();
    }
    
    public void clear() {
        airports.clear();
    }
}
