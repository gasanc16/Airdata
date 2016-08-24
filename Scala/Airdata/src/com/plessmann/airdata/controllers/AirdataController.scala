package com.plessmann.airdata.controllers

import com.plessmann.airdata.Constants
import com.plessmann.airdata.datasource.{Runways, Airports, Countries}
import com.plessmann.airdata.models.{Airport, Country}

/**
 * Created by Plesse on 12/8/2016.
 */
object AirdataController {

  def query(name: String): Unit ={
    val countries = Countries.getCountryByName(name);
    if(!countries.isEmpty) {
      countries.foreach(getAirportsByCountry(_));
    } else {
      println(String.format(Constants.NO_COUNTRY_DATA_TMPL, name))
    }
  }

  def getAirportsByCountry(country: Country): Unit ={
    println(String.format(Constants.COUNTRY_DATA_TMPL, country.name));
    val airports = Airports.getByCountry(country.code.value);
    if(!airports.isEmpty) {
      airports.foreach(getRunwaysByAirport(_));
    } else {
      System.out.println(String.format(Constants.NO_AIRPORT_DATA_TMPL, country.name));
    }
  }

  def getRunwaysByAirport(airport: Airport): Unit ={
    println(String.format(Constants.AIRPORT_DATA_TMPL, airport.name));
    val runways = Runways.getByAirport(airport.id);
    if(!runways.isEmpty) {
      runways.foreach((runway) => println(String.format(Constants.RUNWAY_DATA_TMPL, runway)));
    } else {
      System.out.println(String.format(Constants.NO_RUNWAY_DATA_TMPL, airport.name));
    }
  }

  def reports(): Unit ={
    println(Constants.TOP_COUNTRIES);
    val countriesTop = Countries.sortByAirportsQty(true, true, 10);
    if(!countriesTop.isEmpty) {
      countriesTop.foreach((topCountry) => println(String.format(Constants.COUNTRY_QTY_KEY, topCountry.name, topCountry.airportsQty.toString)));
    }

    println(Constants.BOTTOM_COUNTRIES);
    val countriesBottom = Countries.sortByAirportsQty(false, false, 10);
    if(!countriesBottom.isEmpty) {
      countriesBottom.foreach((topCountry) => println(String.format(Constants.COUNTRY_QTY_KEY, topCountry.name, topCountry.airportsQty.toString)));
    }

    println(Constants.RUNWAY_TYPE_PER_COUNTRY);
    val countries = Countries.sortByName();
    countries.foreach((country) => {
      println(String.format(Constants.COUNTRY_DATA_TMPL, country.name));
      Airports.surface(country).foreach((surface) => println(String.format(Constants.RUNWAY_ID_KEY, surface._1, surface._2.toString)));
    });

    println(Constants.TOP_RUNWAY_ID);
    val topRunwayIdentification = Runways.topRunwayIdentification(10);
    if(!topRunwayIdentification.isEmpty) {
      topRunwayIdentification.foreach((runway) => println(String.format(Constants.RUNWAY_ID_KEY, runway._1, runway._2.toString)))
    }

  }

}
