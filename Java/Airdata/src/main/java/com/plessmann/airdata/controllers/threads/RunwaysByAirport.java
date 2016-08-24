/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers.threads;

import com.plessmann.airdata.datasource.Runways;
import com.plessmann.airdata.models.Airport;
import com.plessmann.airdata.models.Runway;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JProgressBar;

/**
 *
 * @author Plesse
 */
public class RunwaysByAirport extends Thread {
    
    private final Airport airport;
    private final JList list;
    private final JProgressBar progressBar;

    public RunwaysByAirport(Airport airport, JList list, JProgressBar progressBar) {
        this.airport = airport;
        this.list = list;
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        DefaultListModel<Runway> model = new DefaultListModel<>();
        Runways.getInstance().getByAirport(airport.getId()).forEach((runway) -> model.addElement(runway));
        list.setModel(model);
        progressBar.setIndeterminate(false);
    }
    
}
