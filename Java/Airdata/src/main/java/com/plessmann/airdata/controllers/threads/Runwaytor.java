/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.controllers.threads;

import static com.plessmann.airdata.Constants.RUNWAY_ID_KEY;
import com.plessmann.airdata.datasource.Runways;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JProgressBar;

/**
 *
 * @author Plesse
 */
public class Runwaytor extends Thread {

    private final int count;
    private final JList list;
    private final JProgressBar progressBar;
    private final JButton queryButton;

    public Runwaytor(int count, JList list, JProgressBar progressBar, JButton queryButton) {
        this.count = count;
        this.list = list;
        this.progressBar = progressBar;
        this.queryButton = queryButton;
    }
    
    @Override
    public void run() {
        DefaultListModel<String> model = new DefaultListModel<>();
        List<Map.Entry<String, Long>> topRunwayIdentification = Runways.getInstance().topRunwayIdentification(count);
        if(topRunwayIdentification != null && !topRunwayIdentification.isEmpty()) {
           topRunwayIdentification.forEach(runwayId -> model.addElement(String.format(RUNWAY_ID_KEY, runwayId.getKey(), runwayId.getValue())));
        }
        list.setModel(model);
        queryButton.setEnabled(true);
        progressBar.setIndeterminate(false);
    }
    
}
