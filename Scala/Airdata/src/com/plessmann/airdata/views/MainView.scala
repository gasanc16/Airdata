package com.plessmann.airdata.views


import com.plessmann.airdata.Constants
import com.plessmann.airdata.controllers.DataLoader
import com.plessmann.airdata.datasource.{Airports, Countries, Runways}

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.beans.property.StringProperty
import scalafx.geometry.VPos
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color
import scalafx.scene.text.Text
import scalafx.scene.{Group, Scene}
import scalafx.stage.StageStyle

/**
 * Created by Plesse on 13/8/2016.
 */

object MainView  extends JFXApp {
  DataLoader.load();

  val titleProperty = StringProperty("")

  // Process command line parameters
  val stageStyle = parameters.unnamed match {
    case Seq("transparent") => StageStyle.Transparent
    case Seq("undecorated") => StageStyle.Undecorated
    case Seq("utility") => StageStyle.Utility
    case _ => StageStyle.Decorated
  }

  val titleLabel = new Text {
    textOrigin = VPos.Top
  }
  val countriesLabel = new Text {
    textOrigin = VPos.Top
  }
  val airportsLabel = new Text {
    textOrigin = VPos.Top
  }
  val runwaysLabel = new Text {
    textOrigin = VPos.Top
  }
  val titleTextField = new TextField {
    text = Constants.MAIN_TITLE
  }

  stage = new MainStage();

  titleLabel.text <== new StringProperty(Constants.MAIN_TITLE)
  countriesLabel.text <== new StringProperty(Constants.COUNTRIES) + Countries.count()
  airportsLabel.text <== new StringProperty(Constants.AIRPORTS) + Airports.count()
  runwaysLabel.text <== new StringProperty(Constants.RUNWAYS) + Runways.count()
  stage.resizable = false
  stage.title <== titleTextField.text

  stage.initStyle(stageStyle)
  stage.onCloseRequest = handle {println("Stage is closing")}
  stage.show()

}
