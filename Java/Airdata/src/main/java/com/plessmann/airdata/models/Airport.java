/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.models;

import com.plessmann.airdata.Constants;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Plesse
 */
public class Airport {
    
    private int id;
    private String ident;
    private String type;
    private String name;
    private float latitudeDeg;
    private float longitudeDeg;
    private int elevationFt;
    private String continent;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String scheduledService;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private String homeLink;
    private String wikipediaLink;
    private List<String> keywords;
    
    public Airport(String[] airportData) {
        this.id = Integer.parseInt(airportData[0]);
        this.ident = airportData[1];
        this.type = airportData[2];
        this.name = airportData[3];
        this.latitudeDeg = (airportData[4] != null && !airportData[4].isEmpty() ? Float.parseFloat(airportData[4]) : 0);
        this.longitudeDeg = (airportData[5] != null && !airportData[5].isEmpty() ? Float.parseFloat(airportData[5]) : 0);
        this.elevationFt = (airportData[6] != null && !airportData[6].isEmpty() ? Integer.parseInt(airportData[6]) : 0);
        this.continent = airportData[7];
        this.isoCountry = airportData[8];
        this.isoRegion = airportData[9];
        this.municipality = airportData[10];
        this.scheduledService = airportData[11];
        this.gpsCode = airportData[12];
        this.iataCode = airportData[13];
        this.localCode = airportData[14];
        this.homeLink = airportData[15];
        this.wikipediaLink = airportData[16];
        this.keywords = (airportData[17] != null && !airportData[17].isEmpty() ? Arrays.asList(airportData[17].split(",")) : null);
    }
    
    public Airport(int id, String ident, String type, String name, float latitudeDeg, float longitudeDeg, int elevationFt, String continent, String isoCountry, String isoRegion, String municipality, String scheduledService, String gpsCode, String iataCode, String localCode, String homeLink, String wikipediaLink, List<String> keywords) {
        this.id = id;
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.latitudeDeg = latitudeDeg;
        this.longitudeDeg = longitudeDeg;
        this.elevationFt = elevationFt;
        this.continent = continent;
        this.isoCountry = isoCountry;
        this.isoRegion = isoRegion;
        this.municipality = municipality;
        this.scheduledService = scheduledService;
        this.gpsCode = gpsCode;
        this.iataCode = iataCode;
        this.localCode = localCode;
        this.homeLink = homeLink;
        this.wikipediaLink = wikipediaLink;
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitudeDeg() {
        return latitudeDeg;
    }

    public void setLatitudeDeg(float latitudeDeg) {
        this.latitudeDeg = latitudeDeg;
    }

    public float getLongitudeDeg() {
        return longitudeDeg;
    }

    public void setLongitudeDeg(float longitudeDeg) {
        this.longitudeDeg = longitudeDeg;
    }

    public int getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(int elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getScheduledService() {
        return scheduledService;
    }

    public void setScheduledService(String scheduledService) {
        this.scheduledService = scheduledService;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public String getHomeLink() {
        return homeLink;
    }

    public void setHomeLink(String homeLink) {
        this.homeLink = homeLink;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    
    public DefaultListModel<String> getKeywordsAsListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        keywords.forEach((keyword) -> model.addElement(keyword));
        return model;
    }
    
    public boolean hasKeywords(){
        return keywords != null && !keywords.isEmpty();
    }

    @Override
    public String toString() {
        return String.format(Constants.AIRPORT_KEY, id, name);
    }
    
}
