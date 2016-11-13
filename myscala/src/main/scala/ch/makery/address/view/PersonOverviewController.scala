package ch.makery.address.view

import ch.makery.address.model.Person
import ch.makery.address.MainApp
import scalafx.scene.control.{TableView, TableColumn, Label}
import scalafxml.core.macros.sfxml
import scalafx.beans.property.{StringProperty} 

@sfxml
class PersonOverviewController(
  private val personTable : TableView[Person],
  private val firstNameColumn : TableColumn[Person, String],
  private val lastNameColumn : TableColumn[Person, String],
  private val postalColumn :  TableColumn[Person, Int],
  private val firstNameLabel : Label,
  private val lastNameLabel : Label,
  private val streetLabel : Label,
  private val postalCodeLabel : Label,
  private val cityLabel :  Label,
  private val  birthdayLabel : Label 
) {
  // initialize Table View display contents model
  personTable.items = MainApp.personData
  // initialize columns's cell values
  firstNameColumn.cellValueFactory = {_.value.firstName}
  lastNameColumn.cellValueFactory  = {_.value.lastName} 
  postalColumn.cellValueFactory = {_.value.postalCode}
  
  private def showPersonDetails(person: Option[Person]) = {
    person match {
      case Some(person) =>
        // Fill the labels with info from the person object
        firstNameLabel.text <== person.firstName
        lastNameLabel.text <== person.lastName
        streetLabel.text <== person.street
        cityLabel.text <== person.city;
        postalCodeLabel.text = person.postalCode.value.toString
        
      case None =>
        // Person is null, remove all the text
        firstNameLabel.text = ""
        lastNameLabel.text = ""
        streetLabel.text = ""
        postalCodeLabel.text = ""
        cityLabel.text = ""
        birthdayLabel.text = ""
    }
  }
}
