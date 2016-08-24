package com.plessmann.airdata.datasource


import com.plessmann.airdata.models.{Country, Airport}
import scalaz._
import Scalaz._


/**
 * Created by Plesse on 12/8/2016.
 */
object Airports {

  var airports: scala.collection.mutable.MutableList[Airport] = scala.collection.mutable.MutableList();

  def add(airport :Airport): Unit ={
    airports.+=(airport);
  }

  def count() ={
    airports.size;
  }

  def getByCountry(code: String) = {
    airports.filter(_.isoCountry.equals(code)).sortBy(_.name.value);
  }

  def qtyByCountry(country: Country) = {
    getByCountry(country.code.value).size;
  }

  def surface(country: Country) = {
    var result: Map[String, Int] = Map();
    val countryAirports = getByCountry(country.code.value);
    countryAirports.foreach((x) => result = result |+| Runways.getSurface(x));
    result.toSeq.sortBy(-_._2);
  }

  def all() = {
    airports.sortBy(_.name.value);
  }

}
