package com.plessmann.airdata.models

import scalafx.beans.property.StringProperty

/**
 * Created by Plesse on 12/8/2016.
 */
class Airport(idc: Int, identc: String, typeac: String, namec: String, latitudeDegc: Float, longitudeDegc: Float, elevationFtc: Int, continentc: String, isoCountryc: String, isoRegionc: String, municipalityc: String, scheduledServicec: String, gpsCodec: String, iataCodec: String, localCodec: String, homeLinkc: String, wikipediaLinkc: String, keywordsc: List[String]){

  var id: Int = idc;
  var ident: String = identc;
  var typea: String = typeac;
  var name = new StringProperty(this, "name", namec);
  var latitudeDeg: Float = latitudeDegc;
  var longitudeDeg: Float = longitudeDegc;
  var elevationFt: Int = elevationFtc;
  var continent: String = continentc;
  var isoCountry: String = isoCountryc;
  var isoRegion: String = isoRegionc;
  var municipality: String = municipalityc;
  var scheduledService: String = scheduledServicec;
  var gpsCode: String = gpsCodec;
  var iataCode: String = iataCodec;
  var localCode: String = localCodec;
  var homeLink: String = homeLinkc;
  var wikipediaLink: String = wikipediaLinkc;
  var keywords: List[String] = keywordsc;

  override def toString: String = id + " " + name.value;
}
