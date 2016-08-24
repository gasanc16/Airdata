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
public class Country {
    
    private int id;
    private String code;
    private String name;
    private String continent;
    private String wikipediaLink;
    private List<String> keywords;
    private int airportsQty;
    
    public Country(String[] countryData) {
        this.id = Integer.parseInt(countryData[0]);
        this.code = countryData[1];
        this.name = countryData[2];
        this.continent = countryData[3];
        this.wikipediaLink = countryData[4];
        this.keywords = (countryData[5] != null && !countryData[5].isEmpty() ? Arrays.asList(countryData[5].split(",")) : null);
    }

    public Country(int id, String code, String name, String continent, String wikipediaLink, List<String> keywords) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.wikipediaLink = wikipediaLink;
        this.keywords = keywords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
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

    public int getAirportsQty() {
        return airportsQty;
    }

    public void setAirportsQty(int airportsQty) {
        this.airportsQty = airportsQty;
    }
    
    public void increaseAirports(){
        ++airportsQty;
    }
    
    public DefaultListModel<String> getKeywordsAsListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        if(hasKeywords()) {
            keywords.forEach((keyword) -> model.addElement(keyword));
        }
        return model;
    }
    
    public boolean hasKeywords(){
        return keywords != null && !keywords.isEmpty();
    }

    @Override
    public String toString() {
        return String.format(Constants.COUNTRY_KEY, id, code, name);
    }

}
