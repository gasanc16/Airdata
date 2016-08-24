package com.plessmann.airdata.views

import com.plessmann.airdata.Constants
import com.plessmann.airdata.controllers.AirdataViewController
import com.plessmann.airdata.models.{Runway, Airport, Country}
import com.plessmann.airdata.views.MainView._

import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.control.TableView.sfxTableView2jfx
import scalafx.scene.control.{Button, Label, TableColumn, TableView, TextField}
import scalafx.scene.input.{MouseEvent, KeyEvent}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.{Group, Scene}

/**
 * Created by Plesse on 13/8/2016.
 */
class Query extends PrimaryStage{

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
  var airports = new TableView[Airport](AirdataViewController.getAirports(null)){
    columns ++= List(
      TableColumn.sfxTableColumn2jfx(new TableColumn[Airport, String] {
        text = "Name"
        cellValueFactory = {
          _.value.name
        }
        prefWidth = 250
      })
    )
    onMouseClicked =  (a: MouseEvent) => {
      displayCurrentAirportRunways()
    }
  }

  var runways = new TableView[Runway](AirdataViewController.getRunways(null)){
    columns ++= List(
      TableColumn.sfxTableColumn2jfx(new TableColumn[Runway, String] {
        text = "Surface"
        cellValueFactory = {
          _.value.surface
        }
        prefWidth = 250
      })
    )
  }

  private def displayCurrentData(): Unit ={
    sfxTableView2jfx(airports).setItems(AirdataViewController.getAirports(countries.getSelectionModel.getSelectedItem))
  }

  private def displayCurrentAirportRunways(): Unit ={
    sfxTableView2jfx(runways).setItems(AirdataViewController.getRunways(airports.getSelectionModel.getSelectedItem))
  }
  
  val countryTextField = new TextField {
    text = ""
    onKeyReleased = (a: KeyEvent) => {
      sfxTableView2jfx(countries).setItems(AirdataViewController.getCountries(text()))
    }
  }
  resizable = false
  title <== titleProperty
  scene = new Scene(830, 500) {
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
                airports,
                runways
              )
            },
            new HBox{
              spacing = 10
              children = List(
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
      )
    }
  }
}
