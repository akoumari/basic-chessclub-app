package javafxapplication6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
   public static MemberManager m = new MemberManager(100);
    @FXML
    public void ChangeScreenButtonActivatedMember(MouseEvent e)throws IOException{
        Parent viewParent = FXMLLoader.load(getClass().getResource("MemberServices.fxml"));
        Scene otherScene = new Scene(viewParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(otherScene);
    }
    @FXML
    public void ChangeScreenButtonActivateReporting(MouseEvent e) throws IOException{
        Parent viewParent = FXMLLoader.load(getClass().getResource("ReportingServices.fxml"));
        Scene otherScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(otherScene);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
