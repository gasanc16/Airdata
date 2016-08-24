/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata;

import com.plessmann.airdata.controllers.AirdataController;
import com.plessmann.airdata.controllers.DataLoader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Plesse
 */
public class Main {
    
    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        dataLoader.load(args);
        AirdataController airdata =  new AirdataController();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(Constants.GREETING);
            String option;
            while(true) {
                System.out.println(Constants.OPTIONS);
                option = br.readLine();
                switch(option.toLowerCase()){
                    case Constants.ONE:
                    case Constants.QUERY_CONSOLE:
                        System.out.println(Constants.COUNTRY_INPUT);
                        option = br.readLine();
                        airdata.query(option);
                        break;
                    case Constants.TWO:
                    case Constants.REPORTS_CONSOLE:
                        airdata.reports();
                        break;
                    default:
                        System.out.println(Constants.FAREWELL);
                        System.exit(0);
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
