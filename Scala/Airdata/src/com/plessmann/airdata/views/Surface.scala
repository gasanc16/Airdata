package com.plessmann.airdata.views

import com.plessmann.airdata.Constants
import com.plessmann.airdata.controllers.AirdataViewController
import com.plessmann.airdata.models.{Country, ListElement}

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.control.TableView._
import scalafx.scene.control._
import scalafx.scene.input.{KeyEvent, MouseEvent}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.{Group, Scene}

/**
 * Created by Plesse on 15/8/2016.
 */
class Surface extends PrimaryStage{

  var countries = new TableView[Country](AirdataViewController.getCountries("")){
    columns ++= List(
      TableColumn.sfxTableColumn2jfx(new TableColumn[Country, String]() {
        text = "Code"
        cellValueFactory = {
          _.value.code
        }
        prefWidth = 50
      }),
      TableColumn.sfxTableColumn2jfx(new TableColumn[Country, String] {
        text = "Name"
        cellValueFactory = {
          _.value.name
        }
        prefWidth = 200
      })
    )
    onMouseClicked =  (a: MouseEvent) => {
      displayCurrentData()
    }
  }

  var runways = new TableView[ListElement](ObservableBuffer[ListElement]()){
    columns ++= List(
      TableColumn.sfxTableColumn2jfx(new TableColumn[ListElement, String]() {
        text = "Surface"
        cellValueFactory = {
          _.value.element
        }
        prefWidth = 200
      }),
      TableColumn.sfxTableColumn2jfx(new TableColumn[ListElement, String] {
        text = "Count"
        cellValueFactory = {
          _.value.count
        }
        prefWidth = 50
      })
    )
  }

  private def displayCurrentData(): Unit ={
    sfxTableView2jfx(runways).setItems(ObservableBuffer[ListElement]())
    sfxTableView2jfx(runways).setItems(AirdataViewController.getRunwayByCountry(countries.getSelectionModel.getSelectedItem))
  }



  val countryTextField = new TextField {
    text = ""
    onKeyReleased = (a: KeyEvent) => {
      sfxTableView2jfx(countries).setItems(AirdataViewController.getCountries(text()))
    }
  }
  resizable = false
  scene = new Scene(570, 500) {
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
                new Label(Constants.COUNTRY),
                countryTextField
              )
            },
            new HBox{
              spacing = 10
              children = List(
                countries,
                runways
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
