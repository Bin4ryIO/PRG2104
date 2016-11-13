package ch.makery.address
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes._
import scalafxml.core.{NoDependencyResolver, FXMLView, FXMLLoader}
import javafx.{scene => jfxs}
import scalafx.collections.ObservableBuffer
import ch.makery.address.model.Person

object MainApp extends JFXApp {
  /**
     * The data as an observable list of Persons.
     */
  val personData = new ObservableBuffer[Person]()
  
  personData += new Person("Hans", "Muster")
  personData += new Person("Ruth", "Mueller")
  personData += new Person("Heinz", "Kurz")
  personData += new Person("Cornelia", "Meier")
  personData += new Person("Werner", "Meyer")
  personData += new Person("Lydia", "Kunz")
  personData += new Person("Anna", "Best")
  personData += new Person("Stefan", "Meier")
  personData += new Person("Martin", "Mueller")
  

  val rootResource = getClass.getResourceAsStream("view/RootLayout.fxml")
  val loader = new FXMLLoader(null, NoDependencyResolver)
  loader.load(rootResource);
  val roots = loader.getRoot[jfxs.layout.BorderPane]
  
  stage = new PrimaryStage {
    title = "AddressApp"
    scene = new Scene {
      root = roots
    }
  }
  def showPersonOverview() = {
    val resource = getClass.getResourceAsStream("view/PersonOverview.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(resource);
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.setCenter(roots)
  } 
  showPersonOverview()
}