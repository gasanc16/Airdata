/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers;

import com.opencsv.CSVReader;
import com.plessmann.airdata.Constants;
import com.plessmann.airdata.datasource.Airports;
import com.plessmann.airdata.datasource.Countries;
import com.plessmann.airdata.datasource.Runways;
import com.plessmann.airdata.models.Airport;
import com.plessmann.airdata.models.Country;
import com.plessmann.airdata.models.Runway;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Plesse
 */
public class DataLoader {

    public void load() {
        load(null, null, null);
    }
    
    public void load(String[] args) {
        String airports, runways, countries;
        if(args != null && args.length == 3) {
            airports = args[0];
            runways = args[1];
            countries = args[2];
        } else {
            countries = Constants.COUNTRIES_DEFAULT_ROUTE;
            airports = Constants.AIRPORTS_DEFAULT_ROUTE;
            runways = Constants.RUNWAYS_DEFAULT_ROUTE;
        }
        
        try {
            load(countries, 0);
            System.out.println(String.format(Constants.LOADED_COUNTRIES, Countries.getInstance().count()));
            load(airports, 1);
            System.out.println(String.format(Constants.LOADED_AIRPORTS, Airports.getInstance().count()));
            load(runways, 2);
            System.out.println(String.format(Constants.LOADED_RUNWAYS, Runways.getInstance().count()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void load(File countries, File airports, File runways) {
        try {
            load(countries != null ? countries : new File(Constants.COUNTRIES_DEFAULT_ROUTE), 0);
            System.out.println(String.format(Constants.LOADED_COUNTRIES, Countries.getInstance().count()));
            load(airports != null ? airports : new File(Constants.AIRPORTS_DEFAULT_ROUTE), 1);
            System.out.println(String.format(Constants.LOADED_AIRPORTS, Airports.getInstance().count()));
            load(runways != null ? runways : new File(Constants.RUNWAYS_DEFAULT_ROUTE), 2);
            System.out.println(String.format(Constants.LOADED_RUNWAYS, Runways.getInstance().count()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void load(String source, int type) throws FileNotFoundException, IOException {
        load(new File(source), type);
    }
    
    private void load(File source, int type) throws FileNotFoundException, IOException {
        if(type == 0) {
            Countries.getInstance().clear();
        } else if(type == 1) {
            Airports.getInstance().clear();
        } else {
            Runways.getInstance().clear();
        }
        CSVReader reader;
        reader = new CSVReader(new InputStreamReader(new FileInputStream(source), Constants.ENCODING));
        String[] data;
        reader.readNext();
        while ((data = reader.readNext()) != null) {
            if(type == 0) {
                Countries.getInstance().addCountry(new Country(data));
            } else if(type == 1) {
                Airports.getInstance().addAirport(new Airport(data));
            } else {
                Runways.getInstance().addRunway(new Runway(data));
            }
        }
        reader.close();
    }
}
