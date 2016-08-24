package com.plessmann.airdata.datasource

import com.plessmann.airdata.models.Country

/**
 * Created by Plesse on 12/8/2016.
 */
object Countries {

  var countries: scala.collection.mutable.MutableList[Country] = scala.collection.mutable.MutableList();

  def add(country: Country): Unit ={
    countries.+=(country);
  }

  def count() ={
    countries.size;
  }

  def getCountryByName(name: String) ={
    countries.filter((x) => x.name.value.toLowerCase.startsWith(name) || x.code.value.toLowerCase.equals(name)).sortBy(_.name.value);
  }

  def sortByAirportsQty(top: Boolean, calc: Boolean, maxElements: Int) = {
    if(calc){
      countries.foreach((country) => country.airportsQty = Airports.qtyByCountry(country));
    }
    if(top) {
      countries.sortWith((c1, c2) => c1.airportsQty >= c2.airportsQty).slice(0, maxElements);
    } else {
      countries.sortWith((c1, c2) => c1.airportsQty < c2.airportsQty).slice(0, maxElements);
    }
  }

  def sortByName() = {
    countries.sortBy(_.name.value);
  }


}
