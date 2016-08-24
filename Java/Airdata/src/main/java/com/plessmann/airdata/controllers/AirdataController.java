/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers;

import com.plessmann.airdata.Constants;
import com.plessmann.airdata.datasource.Airports;
import com.plessmann.airdata.datasource.Countries;
import com.plessmann.airdata.datasource.Runways;
import com.plessmann.airdata.models.Airport;
import com.plessmann.airdata.models.Country;
import com.plessmann.airdata.models.Runway;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Plesse
 */
public class AirdataController {

    public void query(String name) {
        List<Country> countries = Countries.getInstance().getCountryByName(name.toLowerCase());
        if(countries != null && !countries.isEmpty()) {
            countries.forEach(country -> getAirportsByCountry(country));
        } else {
            System.out.println(String.format(Constants.NO_COUNTRY_DATA_TMPL, name));
        }
    }
    
    public void getAirportsByCountry(Country country) {
        System.out.println(String.format(Constants.COUNTRY_DATA_TMPL, country.getName()));
        List<Airport> airports = Airports.getInstance().getByCountry(country.getCode());
        if(airports != null && !airports.isEmpty()) {
            airports.forEach(airport -> getRunwaysByAirport(airport));
        } else {
            System.out.println(String.format(Constants.NO_AIRPORT_DATA_TMPL, country.getName()));
        }
    }
    
    private void getRunwaysByAirport(Airport airport) {
        System.out.println(String.format(Constants.AIRPORT_DATA_TMPL, airport.getName()));
        List<Runway> runways = Runways.getInstance().getByAirport(airport.getId());
        if(runways != null && !runways.isEmpty()) {
            runways.forEach(runway -> System.out.println(String.format(Constants.RUNWAY_DATA_TMPL, runway)));
        } else {
            System.out.println(String.format(Constants.NO_RUNWAY_DATA_TMPL, airport.getName()));
        }
    }
    
    public void reports() {
        System.out.println(Constants.TOP_COUNTRIES);
        List<Country> countries = Countries.getInstance().sortByAirportsQty(true, true, 10);
        if(countries != null && !countries.isEmpty()) {
           countries.forEach(topCountry -> System.out.println(String.format(Constants.COUNTRY_QTY_KEY, topCountry.getName(), topCountry.getAirportsQty())));
        }
        
        System.out.println(Constants.BOTTOM_COUNTRIES);
        countries = Countries.getInstance().sortByAirportsQty(false, false, 10);
        if(countries != null && !countries.isEmpty()) {
           countries.forEach(topCountry -> System.out.println(String.format(Constants.COUNTRY_QTY_KEY, topCountry.getName(), topCountry.getAirportsQty())));
        }

        System.out.println(Constants.RUNWAY_TYPE_PER_COUNTRY);
        countries = Countries.getInstance().sortByName();
        countries.forEach((actCountry) -> {
            System.out.println(String.format(Constants.COUNTRY_DATA_TMPL, actCountry.getName(), actCountry.getAirportsQty()));
            Airports.getInstance().surface(actCountry).forEach(surface -> System.out.println(String.format(Constants.RUNWAY_ID_KEY, surface.getKey(), surface.getValue())));
        });
        
        System.out.println(Constants.TOP_RUNWAY_ID);
        List<Map.Entry<String, Long>> topRunwayIdentification = Runways.getInstance().topRunwayIdentification(10);
        topRunwayIdentification.forEach(runwayId -> System.out.println(String.format(Constants.RUNWAY_ID_KEY, runwayId.getKey(), runwayId.getValue())));
    }
    
}
