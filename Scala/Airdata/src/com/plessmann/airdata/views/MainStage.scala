package com.plessmann.airdata.views

import com.plessmann.airdata.Constants
import com.plessmann.airdata.views.MainView._

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.control.Button
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.{Group, Scene}
import scalafx.scene.paint.Color

/**
 * Created by Plesse on 15/8/2016.
 */
class MainStage extends PrimaryStage{
  resizable = false
  title <== titleProperty
  scene = new Scene(200, 150) {
    fill = Color.Gray
    content = new Group {
      children = List(
        new VBox {
          layoutX = 30
          layoutY = 20
          spacing = 10
          children = List(
            titleLabel,
            countriesLabel,
            airportsLabel,
            runwaysLabel,
            new HBox{
              spacing = 10
              children = List(
                new Button {
                  text = Constants.QUERY
                  onAction = handle {
                    val query = new Query();
                    query.show();
                  }
                },
                new Button {
                  text = Constants.REPORTS
                  onAction = handle {
                    val reports = new Reports();
                    reports.show();
                  }
                }
              )
            }
          )
        }
      )
    }
  }
}
