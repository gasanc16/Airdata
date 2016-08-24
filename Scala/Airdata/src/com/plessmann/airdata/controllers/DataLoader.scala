package com.plessmann.airdata.controllers

import java.io.File

import com.plessmann.airdata.Constants
import com.plessmann.airdata.datasource.{Runways, Airports, Countries}
import com.plessmann.airdata.models.{Runway, Airport, Country}
import com.github.tototoshi.csv._


/**
 * Created by Plesse on 12/8/2016.
 */
object DataLoader {

  def load(): Unit ={
    load(Constants.COUNTRIES_DEFAULT_ROUTE, 0);
    println(String.format(Constants.LOADED_COUNTRIES, Countries.count().toString));
    load(Constants.AIRPORTS_DEFAULT_ROUTE, 1);
    println(String.format(Constants.LOADED_AIRPORTS, Airports.count().toString));
    load(Constants.RUNWAYS_DEFAULT_ROUTE, 2);
    println(String.format(Constants.LOADED_RUNWAYS, Runways.count().toString));
  }

  def load(dataFile : String, entity : Int): Unit ={
    val reader = CSVReader(new File(dataFile), Constants.ENCODING);
    entity match {
      case 0 => reader.all().drop(1).foreach(() -> loadCountry(_));
      case 1 => reader.all().drop(1).foreach(() -> loadAirport(_));
      case 2 => reader.all().drop(1).foreach(() -> loadRunway(_));
    }
    reader.close();
  }

  def loadCountry(countryData : List[String]): Unit = {
    val country = new Country(countryData(0).toInt, countryData(1), countryData(2), countryData(3), countryData(4), countryData(5).split(",").map(_.trim).toList);
    Countries.add(country);
  }

  def loadAirport(airportData : List[String]): Unit = {
    val airport = new Airport(airportData(0).toInt, airportData(1), airportData(2), airportData(3), Option(airportData(4)).filterNot(_.isEmpty).getOrElse("0").toFloat, Option(airportData(5)).filterNot(_.isEmpty).getOrElse("0").toFloat, Option(airportData(6)).filterNot(_.isEmpty).getOrElse("0").toInt, airportData(7), airportData(8), airportData(9), airportData(10), airportData(11), airportData(12), airportData(13), airportData(14), airportData(15), airportData(16), airportData(17).split(",").map(_.trim).toList);
    Airports.add(airport);
  }

  def loadRunway(runwayData : List[String]): Unit = {
    val runway = new Runway(runwayData(0).toInt,
      runwayData(1).toInt,
      runwayData(2),
      Option(runwayData(3)).filterNot(_.isEmpty).getOrElse("0").toInt,
      Option(runwayData(4)).filterNot(_.isEmpty).getOrElse("0").toInt,
      runwayData(5),
      Option(runwayData(6)).filterNot(_.isEmpty).getOrElse("0").toInt == 1,
      Option(runwayData(7)).filterNot(_.isEmpty).getOrElse("0").toInt == 1,
      runwayData(8),
      Option(runwayData(9)).filterNot(_.isEmpty).getOrElse("0").toFloat,
      Option(runwayData(10)).filterNot(_.isEmpty).getOrElse("0").toFloat,
      Option(runwayData(11)).filterNot(_.isEmpty).getOrElse("0").toInt,
      Option(runwayData(12)).filterNot(_.isEmpty).getOrElse("0").toFloat,
      Option(runwayData(13)).filterNot(_.isEmpty).getOrElse("0").toInt,
      runwayData(14),
      Option(runwayData(15)).filterNot(_.isEmpty).getOrElse("0").toFloat,
      Option(runwayData(16)).filterNot(_.isEmpty).getOrElse("0").toFloat,
      Option(runwayData(17)).filterNot(_.isEmpty).getOrElse("0").toInt,
      Option(runwayData(18)).filterNot(_.isEmpty).getOrElse("0").toFloat,
      Option(runwayData(19)).filterNot(_.isEmpty).getOrElse("0").toInt);
    Runways.add(runway);
  }

}
