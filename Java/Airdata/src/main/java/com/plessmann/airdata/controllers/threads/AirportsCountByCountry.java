/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers.threads;

import static com.plessmann.airdata.Constants.COUNTRY_QTY_KEY;
import com.plessmann.airdata.datasource.Countries;
import com.plessmann.airdata.models.Country;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JProgressBar;

/**
 *
 * @author Plesse
 */
public class AirportsCountByCountry extends Thread {
    
    private final boolean mode;
    private final int count;
    private final JList list; 
    private final JProgressBar progressBar;
    private final JButton queryButton;

    public AirportsCountByCountry(boolean mode, int count, JList list, JProgressBar progressBar, JButton queryButton) {
        this.mode = mode;
        this.count = count;
        this.list = list;
        this.progressBar = progressBar;
        this.queryButton = queryButton;
    }
    
    @Override
    public void run() {
        DefaultListModel<String> model = new DefaultListModel<>();
        List<Country> countries = Countries.getInstance().sortByAirportsQty(mode, true, count);
        if(countries != null && !countries.isEmpty()) {
           countries.forEach(topCountry -> model.addElement(String.format(COUNTRY_QTY_KEY, topCountry.getName(), topCountry.getAirportsQty())));
        }
        list.setModel(model);
        queryButton.setEnabled(true);
        progressBar.setIndeterminate(false);
    }
    
}
