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
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class ReadNoteUIController implements Initializable {

    @FXML 
    private Text readModeTitle;
    
    @FXML
    private TextFlow readModeDescription;
    
    @FXML
    public void backButton(ActionEvent event) throws IOException{
    //This is how to switch from one scene to another.
     Parent HomeParent = FXMLLoader.load(getClass().getResource("ListNotesUI.fxml"));
     Scene new_note_scene = new Scene(HomeParent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     app_stage.setScene(new_note_scene);
     app_stage.show();
    
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
