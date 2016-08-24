/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers.threads;

import static com.plessmann.airdata.Constants.RUNWAY_ID_KEY;
import com.plessmann.airdata.datasource.Airports;
import com.plessmann.airdata.models.Country;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JProgressBar;

/**
 *
 * @author Plesse
 */
public class Surfacetor extends Thread {

    private final Country country;
    private final JProgressBar progressBar;
    private final JList list;
    private final JList sourceList;

    public Surfacetor(Country country, JProgressBar progressBar, JList list, JList sourceList) {
        this.country = country;
        this.progressBar = progressBar;
        this.list = list;
        this.sourceList = sourceList;
    }
    
    @Override
    public void run() {
        DefaultListModel<String> model = new DefaultListModel<>();
        Airports.getInstance().surface(country).forEach(surface -> model.addElement(String.format(RUNWAY_ID_KEY, surface.getKey(), surface.getValue())));
        list.setModel(model);
        sourceList.setEnabled(true);
        progressBar.setIndeterminate(false);
    }
    
}
