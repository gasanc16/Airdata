package com.plessmann.airdata.views

import com.plessmann.airdata.Constants
import com.plessmann.airdata.views.MainView._

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.control.Button
import scalafx.scene.layout.VBox
import scalafx.scene.{Group, Scene}
import scalafx.scene.paint.Color

/**
 * Created by Plesse on 15/8/2016.
 */
class Reports extends PrimaryStage{
  resizable = false
  title <== titleProperty
  scene = new Scene(220, 200) {
    fill = Color.Gray
    content = new Group {
      children = List(
        new VBox {
          layoutX = 30
          layoutY = 20
          spacing = 10
          children = List(
            new Button {
              text = Constants.HIGH
              onAction = handle {
                val high = new ListView(0);
                high.show();
              }
            },
            new Button {
              text = Constants.LOW
              onAction = handle {
                val low = new ListView(1);
                low.show();
              }
            },
            new Button {
              text = Constants.SURFACE
              onAction = handle {
                val surface = new Surface();
                surface.show();
              }
            },
            new Button {
              text = Constants.IDENTS
              onAction = handle {
                val idents = new ListView(2);
                idents.show();
              }
            },
            new Button {
              text = "Back"
              onAction = handle {
                val stage2 = new MainStage()
                stage2.show()
              }
            }
          )
        }
      )
    }
  }
}