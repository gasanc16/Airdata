/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.datasource;

import com.plessmann.airdata.models.Airport;
import com.plessmann.airdata.models.Runway;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author Plesse
 */
public class Runways {
    
    protected static Runways me = null;
    
    private final List<Runway> runways;

    public Runways() {
        runways = new ArrayList<>();
    }
    
    public static synchronized Runways getInstance() {
        if(me == null){
            me = new Runways();
        }
        return me;
    }
    
    public void addRunway(Runway runway) {
        runways.add(runway);
    }
    
    public List<Runway> getByAirport(int airportCode) {
        return runways.stream().filter(runway -> runway.getAirportRef() == airportCode).collect(Collectors.toList());
    }
    
    public List<Entry<String, Long>> topRunwayIdentification(int maxElements) {
        Map<String, Long> valueCounts = runways.stream().collect(Collectors.groupingBy(Runway::getLeIdent,Collectors.counting()));
        return valueCounts.entrySet().stream().sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).collect(Collectors.toList()).subList(0, maxElements);
    }
    
    public Map<String, Long> getSurface(Airport airport) {
        return runways.stream().filter(runway -> runway.getAirportRef() == airport.getId()).collect(Collectors.groupingBy(Runway::getSurface,Collectors.counting()));
    }
    
    public int count() {
        return runways.size();
    }
    
    public void clear() {
        runways.clear();
    }
}
