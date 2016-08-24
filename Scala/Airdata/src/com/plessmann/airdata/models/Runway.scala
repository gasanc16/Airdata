package com.plessmann.airdata.models

import com.plessmann.airdata.Constants

import scalafx.beans.property.StringProperty

/**
 * Created by Plesse on 12/8/2016.
 */
class Runway(idc: Int, airportRefc: Int, airportIdentc: String, lengthFtc: Int, widthFtc: Int, surfacec: String, lightedc: Boolean, closedc: Boolean, leIdentc: String, leLatitudeDegc: Float, leLongitudeDegc: Float, leElevationFtc: Int,leHeadingDegTc: Float, leDisplacedThresholdFtc: Int, heIdentc: String, he_latitude_degc: Float, he_longitude_degc: Float, heElevationFtc: Int, heHeadingDegTc: Float, heDisplacedThresholdFtc: Int) {

  var id: Int = idc;
  var airportRef: Int = airportRefc;
  var airportIdent: String = airportIdentc;
  var lengthFt: Int = lengthFtc;
  var widthFt: Int = widthFtc;
  var surface = new StringProperty(this, "surface", surfacec);
  var lighted: Boolean = lightedc;
  var closed: Boolean = closedc;
  var leIdent: String = leIdentc;
  var leLatitudeDeg: Float = leLatitudeDegc;
  var leLongitudeDeg: Float = leLongitudeDegc;
  var leElevationFt: Int = leElevationFtc;
  var leHeadingDegT: Float = leHeadingDegTc;
  var leDisplacedThresholdFt: Int = leDisplacedThresholdFtc;
  var heIdent: String = heIdentc;
  var he_latitude_deg: Float = he_latitude_degc;
  var he_longitude_deg: Float = he_longitude_degc;
  var heElevationFt: Int = heElevationFtc;
  var heHeadingDegT: Float = heHeadingDegTc;
  var heDisplacedThresholdFt: Int = heDisplacedThresholdFtc;

  override def toString: String = {
    val json = new StringBuilder();
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
