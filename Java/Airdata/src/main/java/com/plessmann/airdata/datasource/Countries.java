/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.datasource;

import com.plessmann.airdata.models.Country;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Plesse
 */
public class Countries {
    
    protected static Countries me = null;
    
    private final List<Country> countries;

    public Countries() {
        countries = new ArrayList<>();
    }
    
    public static synchronized Countries getInstance() {
        if(me == null){
            me = new Countries();
        }
        return me;
    }
    
    public void addCountry(Country country) {
        countries.add(country);
    }
    
    public List<Country> getCountryByName(String name) {
        return countries.stream().filter(country -> country.getName().toLowerCase().startsWith(name) || country.getCode().toLowerCase().equals(name)).collect(Collectors.toList());
    }
    
    public List<Country> sortByAirportsQty(boolean top, boolean calc, int maxElements){
        if(calc){
            countries.forEach((country) -> country.setAirportsQty(Airports.getInstance().qtyByCountry(country)));
        }
        countries.sort((p1, p2) -> top ? p2.getAirportsQty() - p1.getAirportsQty() : p1.getAirportsQty() - p2.getAirportsQty());
        return countries.subList(0, maxElements);
    }
    
    public List<Country> sortByName() {
        countries.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        return countries;
    }

    public int count() {
        return countries.size();
    }

    public void clear() {
        countries.clear();
    }
}
