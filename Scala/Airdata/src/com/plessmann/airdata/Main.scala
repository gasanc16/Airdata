package com.plessmann.airdata

import com.plessmann.airdata.controllers.{AirdataController, DataLoader}

import scala.util.control.Breaks._

/**
 * Created by Plesse on 12/8/2016.
 */
object Main {
  def main(args: Array[String]) {
    try{
      DataLoader.load();
      println(Constants.GREETING);
      println(Constants.OPTIONS);
      var option = scala.io.StdIn.readLine();
      breakable {
        while(true) {
          option match {
            case Constants.ONE | Constants.QUERY_CONSOLE => { println(Constants.COUNTRY_INPUT);
                                    option = scala.io.StdIn.readLine();
                                    AirdataController.query(option);
                                  };
            case Constants.TWO | Constants.REPORTS_CONSOLE => AirdataController.reports();
            case _ => break;
          }
          println(Constants.OPTIONS);
          option = scala.io.StdIn.readLine();
        }
      }
      println(Constants.FAREWELL);
    } catch {
      case ex: Exception => {
        println(ex.getMessage);
      }
    }
  }
}
