package com.plessmann.airdata.views

import com.plessmann.airdata.Constants
import com.plessmann.airdata.controllers.AirdataViewController
import com.plessmann.airdata.models.ListElement

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.TableView.sfxTableView2jfx
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.{Group, Scene}

/**
 * Created by Plesse on 15/8/2016.
 */
class ListView(operationc: Int) extends PrimaryStage{

  var operation: Int = operationc;

  var elements = new TableView[ListElement](ObservableBuffer[ListElement]()){
    columns ++= List(
      TableColumn.sfxTableColumn2jfx(new TableColumn[ListElement, String]() {
        text = "Element"
        cellValueFactory = {
          _.value.element
        }
        prefWidth = 100
      }),
      TableColumn.sfxTableColumn2jfx(new TableColumn[ListElement, String] {
        text = "Count"
        cellValueFactory = {
          _.value.count
        }
        prefWidth = 100
      })
    )
  }

  var sizeSelector = new ComboBox[Int] {
    maxWidth = 200
    promptText = "Pick a value"
    items = ObservableBuffer(10, 20, 30, 40, 50)
  }

  private def executeQuery(): Unit ={
    val size = sizeSelector.getSelectionModel.getSelectedItem
    if(size != null) {
      sfxTableView2jfx(elements).setItems(if(operation == 2) AirdataViewController.getRunwayType(size) else AirdataViewController.getAirportsCountByCountry(operation == 0, size))
    }
  }

  resizable = false
  scene = new Scene(300, 500) {
    fill = Color.Gray
    content = new Group {
      children = List(
        new VBox {
          layoutX = 30
          layoutY = 20
          spacing = 10
          children = List(
            new HBox {
              spacing = 10
              children = List(
                sizeSelector,
                new Button {
                  text = Constants.QUERY
                  onAction = handle {
                    executeQuery()
                  }
                }
              )
            },
            new HBox{
              spacing = 10
              children = List(
                elements
              )
            },
            new HBox{
              spacing = 10
              children = List(
                new Button {
                  text = "Back"
                  onAction = handle {
                    val reports = new Reports()
                    reports.show()
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