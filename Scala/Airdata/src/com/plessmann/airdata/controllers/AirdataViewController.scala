package com.plessmann.airdata.controllers

import com.plessmann.airdata.datasource.{Airports, Countries, Runways}
import com.plessmann.airdata.models._

import scalafx.collections.ObservableBuffer

/**
 * Created by Plesse on 15/8/2016.
 */
object AirdataViewController {

  def getCountries(name: String) = {
    ObservableBuffer[Country](
      Countries.getCountryByName(name)
    )
  }

  def getAirports(country: Country) = {
    ObservableBuffer[Airport](
      if(country == null) Airports.all() else Airports.getByCountry(country.code.value)
    )
  }

  def getRunways(airport: Airport) = {
      ObservableBuffer[Runway](
        if(airport == null) Runways.all() else Runways.getByAirport(airport.id)
      )
  }

  def getAirportsCountByCountry(mode: Boolean, count : Int) = {
    ObservableBuffer[ListElement](
      Countries.sortByAirportsQty(mode, true, count).map( x => new ListElement(x.name.value, x.airportsQty.toString))
    )
  }

  def getRunwayType(count : Int) = {
    ObservableBuffer[ListElement](
      Runways.topRunwayIdentification(count).map( x => new ListElement(x._1, x._2.toString))
    )
  }

  def getRunwayByCountry(country: Country) = {
    ObservableBuffer[ListElement](
      Airports.surface(country).map( x => new ListElement(x._1, x._2.toString))
    )
  }

}
