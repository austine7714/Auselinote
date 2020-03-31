/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auselinotes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AddEditUIController implements Initializable {
@FXML
private TextField noteTitle;

@FXML
private TextArea noteDescription;



   @FXML
   private void cancelButton(ActionEvent event){
     
   
   }
      @FXML
   private void clearButton(ActionEvent event){
   
   
   }
      @FXML
   private void saveButton(ActionEvent event) throws IOException{
       //Creating a loader object we can use to access the controller of the ListNotesUI.
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ListNotesUI.fxml"));
        Parent tableViewParent = loader.load();
        Scene tableViewScene = new Scene(tableViewParent);
        //to access the controller
        
        //Acessing the FXML Controller of ListNotesUI
        FXMLDocumentController controller = loader.getController();
       //This creates a new notein the ArrayList in the BaseController             
     BaseController newNote = new BaseController(noteTitle.getText(), 
                                                 noteDescription.getText());
     //we need to get all items fromthe table and then add a new one back to the tablelist.
     controller.initData(newNote);
       // this takes us backtoour Home page 
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.setScene(tableViewScene);
     app_stage.show();
   
   }
   
   //The notesList button will take you back to the ListNotesUI, which is the home page.
    @FXML
    private void notesListButton(ActionEvent event) throws IOException{
    //This is how to switch from one scene to another.
     Parent HomeParent = FXMLLoader.load(getClass().getResource("ListNotesUI.fxml"));
     Scene new_note_scene = new Scene(HomeParent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.setScene(new_note_scene);
     app_stage.show();
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

}
