/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers.threads;

import com.plessmann.airdata.datasource.Airports;
import com.plessmann.airdata.models.Airport;
import com.plessmann.airdata.models.Country;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;

/**
 *
 * @author Plesse
 */
public class Airporter extends Thread {

    private final Country country;
    private final JList airportsList; 
    private final JLabel airportsQty;
    private final JProgressBar progressBar;
    private final JList sourceList;

    public Airporter(Country country, JList airportsList, JLabel airportsQty, JProgressBar progressBar, JList sourceList) {
        this.country = country;
        this.airportsList = airportsList;
        this.airportsQty = airportsQty;
        this.progressBar = progressBar;
        this.sourceList = sourceList;
    }
    
    @Override
    public void run() {
        DefaultListModel<Airport> model = new DefaultListModel<>();
        Airports.getInstance().getByCountry(country.getCode()).forEach((airport) -> model.addElement(airport));
        airportsQty.setText(String.valueOf(model.size()));
        airportsList.setModel(model);
        sourceList.setEnabled(true);
        progressBar.setIndeterminate(false);
    }
    
}
