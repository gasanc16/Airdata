package com.plessmann.airdata.datasource

import com.plessmann.airdata.models.{Airport, Runway}

/**
 * Created by Plesse on 12/8/2016.
 */
object Runways {

  var runways: scala.collection.mutable.MutableList[Runway] = scala.collection.mutable.MutableList();

  def add(runway :Runway): Unit ={
    runways.+=(runway);
  }

  def count() ={
    runways.size;
  }

  def getByAirport(airportCode: Int) = {
    runways.filter(_.airportRef == airportCode).sortBy(_.surface.value);
  }

  def topRunwayIdentification(maxElements: Int) = {
    runways.groupBy(_.leIdent).map(x => (x._1, x._2.size)).toSeq.sortBy(-_._2).slice(0, maxElements);
  }

  def getSurface(airport: Airport) = {
    runways.filter(_.airportRef == airport.id).groupBy(_.surface.value).map(x => (x._1, x._2.size));
  }

  def all() = {
    runways.sortBy(_.surface.value);
  }

}
