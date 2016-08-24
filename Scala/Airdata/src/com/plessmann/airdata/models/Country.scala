package com.plessmann.airdata.models

import scalafx.beans.property.{IntegerProperty, StringProperty}

/**
 * Created by Plesse on 12/8/2016.
 */
class Country(idc: Int, codec: String, namec: String, continentc: String, wikipediaLinkc: String, keywordsc: List[String]) {

  var id = new IntegerProperty(this, "id", idc);
  var code = new StringProperty(this, "code", codec);
  var name = new StringProperty(this, "name", namec);
  var continent: String = continentc;
  var wikipediaLink: String = wikipediaLinkc;
  var keywords: List[String] = keywordsc ;
  var airportsQty: Int = 0;

  override def toString: String = id.value + " "+ code.value + " " + name.value;
}
