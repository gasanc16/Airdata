/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata.models;

import com.plessmann.airdata.Constants;

/**
 *
 * @author Plesse
 */
public class Runway {
    
    private int id;
    private int airportRef;
    private String airportIdent;
    private int lengthFt;
    private int widthFt;
    private String surface;
    private boolean lighted;
    private boolean closed;
    private String leIdent;
    private float leLatitudeDeg;
    private float leLongitudeDeg;
    private int leElevationFt;
    private float leHeadingDegT;
    private int leDisplacedThresholdFt;
    private String heIdent;
    private float he_latitude_deg;
    private float he_longitude_deg;
    private int heElevationFt;
    private float heHeadingDegT;
    private int heDisplacedThresholdFt;
    
    public Runway(String[] runwayData) {
        this.id = Integer.parseInt(runwayData[0]);
        this.airportRef = Integer.parseInt(runwayData[1]);
        this.airportIdent = runwayData[2];
        this.lengthFt = (runwayData[3] != null && !runwayData[3].isEmpty() ? Integer.parseInt(runwayData[3]) : 0);
        this.widthFt = (runwayData[4] != null && !runwayData[4].isEmpty() ? Integer.parseInt(runwayData[4]) : 0);
        this.surface = runwayData[5];
        this.lighted = (runwayData[6] != null && !runwayData[6].isEmpty() ? Integer.parseInt(runwayData[6]) == 1 : false);
        this.closed = (runwayData[7] != null && !runwayData[7].isEmpty() ? Integer.parseInt(runwayData[7]) == 1 : false);
        this.leIdent = runwayData[8];
        this.leLatitudeDeg = (runwayData[9] != null && !runwayData[9].isEmpty() ? Float.parseFloat(runwayData[9]) : 0);
        this.leLongitudeDeg = (runwayData[10] != null && !runwayData[10].isEmpty() ? Float.parseFloat(runwayData[10]) : 0);
        this.leElevationFt = (runwayData[11] != null && !runwayData[11].isEmpty() ? Integer.parseInt(runwayData[11]) : 0);
        this.leHeadingDegT = (runwayData[12] != null && !runwayData[12].isEmpty() ? Float.parseFloat(runwayData[12]) : 0);
        this.leDisplacedThresholdFt = (runwayData[13] != null && !runwayData[13].isEmpty() ? Integer.parseInt(runwayData[13]) : 0);
        this.heIdent = runwayData[14];
        this.he_latitude_deg = (runwayData[15] != null && !runwayData[15].isEmpty() ? Float.parseFloat(runwayData[15]) : 0);
        this.he_longitude_deg = (runwayData[16] != null && !runwayData[16].isEmpty() ? Float.parseFloat(runwayData[16]) : 0);
        this.heElevationFt = (runwayData[17] != null && !runwayData[17].isEmpty() ? Integer.parseInt(runwayData[17]) : 0);
        this.heHeadingDegT = (runwayData[18] != null && !runwayData[18].isEmpty() ? Float.parseFloat(runwayData[18]) : 0);
        this.heDisplacedThresholdFt = (runwayData[19] != null && !runwayData[19].isEmpty() ? Integer.parseInt(runwayData[19]) : 0);
    }

    public Runway(int id, int airportRef, String airportIdent, int lengthFt, int widthFt, String surface, boolean lighted, boolean closed, String leIdent, float leLatitudeDeg, float leLongitudeDeg, int leElevationFt, float leHeadingDegT, int leDisplacedThresholdFt, String heIdent, float he_latitude_deg, float he_longitude_deg, int heElevationFt, float heHeadingDegT, int heDisplacedThresholdFt) {
        this.id = id;
        this.airportRef = airportRef;
        this.airportIdent = airportIdent;
        this.lengthFt = lengthFt;
        this.widthFt = widthFt;
        this.surface = surface;
        this.lighted = lighted;
        this.closed = closed;
        this.leIdent = leIdent;
        this.leLatitudeDeg = leLatitudeDeg;
        this.leLongitudeDeg = leLongitudeDeg;
        this.leElevationFt = leElevationFt;
        this.leHeadingDegT = leHeadingDegT;
        this.leDisplacedThresholdFt = leDisplacedThresholdFt;
        this.heIdent = heIdent;
        this.he_latitude_deg = he_latitude_deg;
        this.he_longitude_deg = he_longitude_deg;
        this.heElevationFt = heElevationFt;
        this.heHeadingDegT = heHeadingDegT;
        this.heDisplacedThresholdFt = heDisplacedThresholdFt;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirportRef() {
        return airportRef;
    }

    public void setAirportRef(int airportRef) {
        this.airportRef = airportRef;
    }

    public String getAirportIdent() {
        return airportIdent;
    }

    public void setAirportIdent(String airportIdent) {
        this.airportIdent = airportIdent;
    }

    public int getLengthFt() {
        return lengthFt;
    }

    public void setLengthFt(int lengthFt) {
        this.lengthFt = lengthFt;
    }

    public int getWidthFt() {
        return widthFt;
    }

    public void setWidthFt(int widthFt) {
        this.widthFt = widthFt;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public boolean isLighted() {
        return lighted;
    }

    public void setLighted(boolean lighted) {
        this.lighted = lighted;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getLeIdent() {
        return leIdent;
    }

    public void setLeIdent(String leIdent) {
        this.leIdent = leIdent;
    }

    public float getLeLatitudeDeg() {
        return leLatitudeDeg;
    }

    public void setLeLatitudeDeg(float leLatitudeDeg) {
        this.leLatitudeDeg = leLatitudeDeg;
    }

    public float getLeLongitudeDeg() {
        return leLongitudeDeg;
    }

    public void setLeLongitudeDeg(float leLongitudeDeg) {
        this.leLongitudeDeg = leLongitudeDeg;
    }

    public int getLeElevationFt() {
        return leElevationFt;
    }

    public void setLeElevationFt(int leElevationFt) {
        this.leElevationFt = leElevationFt;
    }

    public float getLeHeadingDegT() {
        return leHeadingDegT;
    }

    public void setLeHeadingDegT(float leHeadingDegT) {
        this.leHeadingDegT = leHeadingDegT;
    }

    public int getLeDisplacedThresholdFt() {
        return leDisplacedThresholdFt;
    }

    public void setLeDisplacedThresholdFt(int leDisplacedThresholdFt) {
        this.leDisplacedThresholdFt = leDisplacedThresholdFt;
    }

    public String getHeIdent() {
        return heIdent;
    }

    public void setHeIdent(String heIdent) {
        this.heIdent = heIdent;
    }

    public float getHe_latitude_deg() {
        return he_latitude_deg;
    }

    public void setHe_latitude_deg(float he_latitude_deg) {
        this.he_latitude_deg = he_latitude_deg;
    }

    public float getHe_longitude_deg() {
        return he_longitude_deg;
    }

    public void setHe_longitude_deg(float he_longitude_deg) {
        this.he_longitude_deg = he_longitude_deg;
    }

    public int getHeElevationFt() {
        return heElevationFt;
    }

    public void setHeElevationFt(int heElevationFt) {
        this.heElevationFt = heElevationFt;
    }

    public float getHeHeadingDegT() {
        return heHeadingDegT;
    }

    public void setHeHeadingDegT(float heHeadingDegT) {
        this.heHeadingDegT = heHeadingDegT;
    }

    public int getHeDisplacedThresholdFt() {
        return heDisplacedThresholdFt;
    }

    public void setHeDisplacedThresholdFt(int heDisplacedThresholdFt) {
        this.heDisplacedThresholdFt = heDisplacedThresholdFt;
    }

    @Override
    public String toString() {
        StringBuilder json = new StringBuilder();
        json.append(Constants.OPEN_BRACKET);
        json.append(Constants.RUNWAY_ID).append(id);
        json.append(Constants.RUNWAY_AIRPORT_REF).append(airportRef).append(Constants.DOUBLE);
        json.append(Constants.RUNWAY_AIRPORT_IDENT).append(airportIdent).append(Constants.DOUBLE);
        json.append(Constants.RUNWAY_LENGTH).append(lengthFt);
        json.append(Constants.RUNWAY_WIDTH).append(widthFt);
        json.append(Constants.RUNWAY_SURFACE).append(surface).append(Constants.DOUBLE);
        json.append(Constants.RUNWAY_LIGHTED).append(lighted);
        json.append(Constants.RUNWAY_CLOSED).append(closed);
        json.append(Constants.RUNWAY_LE_IDENT).append(leIdent).append(Constants.DOUBLE);
        json.append(Constants.RUNWAY_LE_LATITUDE).append(leLatitudeDeg);
        json.append(Constants.RUNWAY_LE_LONGITUDE).append(leLongitudeDeg);
        json.append(Constants.RUNWAY_LE_ELEVATION).append(leElevationFt);
        json.append(Constants.RUNWAY_LE_HEADING).append(leHeadingDegT);
        json.append(Constants.RUNWAY_LE_DISPLACED).append(leDisplacedThresholdFt);
        json.append(Constants.RUNWAY_HE_IDENT).append(heIdent).append(Constants.DOUBLE);
        json.append(Constants.RUNWAY_HE_LATITUDE).append(he_latitude_deg);
        json.append(Constants.RUNWAY_HE_LONGITUDE).append(he_longitude_deg);
        json.append(Constants.RUNWAY_HE_ELEVATION).append(heElevationFt);
        json.append(Constants.RUNWAY_HE_HEADING).append(heHeadingDegT);
        json.append(Constants.RUNWAY_HE_DISPLACED).append(heDisplacedThresholdFt);
        json.append(Constants.CLOSE_BRACKET);
        return json.toString();
    }
}
