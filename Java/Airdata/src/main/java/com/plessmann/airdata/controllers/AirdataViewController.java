/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers;

import com.plessmann.airdata.controllers.threads.Airporter;
import com.plessmann.airdata.controllers.threads.AirportsCountByCountry;
import com.plessmann.airdata.controllers.threads.CountryFinder;
import com.plessmann.airdata.controllers.threads.RunwaysByAirport;
import com.plessmann.airdata.controllers.threads.Runwaytor;
import com.plessmann.airdata.controllers.threads.Surfacetor;
import com.plessmann.airdata.models.Airport;
import com.plessmann.airdata.models.Country;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author Plesse
 */
public class AirdataViewController {
    
    public static void queryForView(JTextField name, JList list, JProgressBar progressBar) {
        progressBar.setIndeterminate(true);
        name.setEditable(false);
        new CountryFinder(list, progressBar, name).start();
    }
    
    public static void getAirportsByCountryForView(Country country, JList airportsList, JLabel airportsQty, JProgressBar progressBar, JList sourceList) {
        progressBar.setIndeterminate(true);
        sourceList.setEnabled(false);
        new Airporter(country, airportsList, airportsQty, progressBar, sourceList).start();
    }
    
    public static void getRunwaysByAirportForView(Airport airport, JList list, JProgressBar progressBar) {
        progressBar.setIndeterminate(true);
        new RunwaysByAirport(airport, list, progressBar).start();
    }
    
    public static void getAirportsCountByCountry(boolean mode, int count, JList list, JProgressBar progressBar, JButton queryButton) {
        progressBar.setIndeterminate(true);
        queryButton.setEnabled(false);
        new AirportsCountByCountry(mode, count, list, progressBar, queryButton).start();
    }
    
    public static void getRunwayType(int count, JList list, JProgressBar progressBar, JButton queryButton) {
        progressBar.setIndeterminate(true);
        queryButton.setEnabled(false);
        new Runwaytor(count, list, progressBar, queryButton).start();
    }
    
    public static void getRunwayByCountry(Country country, JList list, JProgressBar progressBar, JList sourceList) {
        progressBar.setIndeterminate(true);
        sourceList.setEnabled(false);
        new Surfacetor(country, progressBar, list, sourceList).start();
    }
}
