/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auselinotes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;




/**
 *
 * @author PC
 */
public class FXMLDocumentController implements Initializable {
  @FXML
 private TableView<BaseController>  tableView;
 @FXML
 private TableColumn<BaseController, String> titleColumn;
 @FXML
 private TableColumn<BaseController, String> descriptionColumn;
 
 private BaseController selectedNote;
 
    
    
    
   @FXML
   private void deleteButton(ActionEvent event) throws IOException{
        //This is how to switch from one scene to another.
     Parent HomeParent = FXMLLoader.load(getClass().getResource("ListNotesUI.fxml"));
     Scene new_note_scene = new Scene(HomeParent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.setScene(new_note_scene);
     app_stage.show();
   }
   @FXML
   private void editButton(ActionEvent event) throws IOException{
 

     
     
   
   }
   
    @FXML
   private void viewNoteButton(ActionEvent event) throws IOException{
  //This is how to switch from one scene to another.
     Parent HomeParent = FXMLLoader.load(getClass().getResource("ReadNoteUI.fxml"));
     Scene new_note_scene = new Scene(HomeParent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.setScene(new_note_scene);
     app_stage.show();

     
     
   
   }
    
    @FXML
    private void newNoteButton(ActionEvent event) throws IOException {
    //This is how to switch from one scene to another.
     Parent HomeParent = FXMLLoader.load(getClass().getResource("AddEditUI.fxml"));
     Scene new_note_scene = new Scene(HomeParent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.setScene(new_note_scene);
     app_stage.show();
     
    }
    //This method will allow a user to double click on a cell and edit it.
    //This is for editing the cells in the title column. 
    
    public void changeTitleCellEvent(CellEditEvent editedCell){
       BaseController noteSelected = tableView.getSelectionModel().getSelectedItem();
       noteSelected.setTitle(editedCell.getNewValue().toString());
    }
    
    //This method will allow a user to double click on a cell and edit it.
    //This is for editing the cells in the Description column
    
    public void changeDescriptionCellEvent(CellEditEvent editedCell){
       BaseController noteSelected = tableView.getSelectionModel().getSelectedItem();
       noteSelected.setDescription(editedCell.getNewValue().toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<BaseController, String>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<BaseController, String>("description"));
    
        tableView.setItems(getNotes());
        
        //Update the Table to be able to allow the title and descriptions to be editable
        tableView.setEditable(true);
        
        titleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
       
    }    
    
    
    //This method sets Up dummy data in the TableView.
    public ObservableList<BaseController> getNotes(){
    
    ObservableList<BaseController> Note = FXCollections.observableArrayList();
    Note.add(new BaseController("Note1","Description1"));
    Note.add(new BaseController("Note2", "Description2"));
                   
    return Note;
    }
    //This gets the data from the addEditUIController.
 public void initData(BaseController note){
       selectedNote = note;
       tableView.getItems().add(note);
       
 }
}
