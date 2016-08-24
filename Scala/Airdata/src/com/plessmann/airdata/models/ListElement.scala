package com.plessmann.airdata.models

import scalafx.beans.property.StringProperty

/**
 * Created by Plesse on 15/8/2016.
 */
class ListElement(elementc: String, countc: String) {
  var element = new StringProperty(this, "element", elementc);
  var count = new StringProperty(this, "count", countc);
}
