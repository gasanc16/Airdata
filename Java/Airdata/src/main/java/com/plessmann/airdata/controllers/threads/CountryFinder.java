/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers.threads;

import com.plessmann.airdata.datasource.Countries;
import com.plessmann.airdata.models.Country;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 *
 * @author Plesse
 */
public class CountryFinder extends Thread {

    private final JList countriesList; 
    private final JProgressBar progressBar;
    private final JTextField name;

    public CountryFinder(JList countriesList, JProgressBar progressBar, JTextField name) {
        this.countriesList = countriesList;
        this.progressBar = progressBar;
        this.name = name;
    }
    
    @Override
    public void run() {
        DefaultListModel<Country> model = new DefaultListModel<>();
        if(name.getText() == null || name.getText().isEmpty()) {
            Countries.getInstance().sortByName().forEach((country) -> model.addElement(country));
        } else {
            Countries.getInstance().getCountryByName(name.getText().toLowerCase()).forEach((country) -> model.addElement(country));
        }
        try {
            countriesList.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        name.setEditable(true);
        progressBar.setIndeterminate(false);
    }
    
}
