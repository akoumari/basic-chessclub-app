package javafxapplication6;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javafxapplication6.FXMLDocumentController.m;

public class MemberServicesController implements Initializable {

    @FXML public TextField fName;
    @FXML public Label message;
    @FXML public TextField lName;
    @FXML public TextField playerId;
    @FXML public ListView<Member> memberList;
    
    @FXML
    public void backToMain(MouseEvent e)throws IOException{
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene otherScene = new Scene(viewParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(otherScene);
    }
    @FXML
    public void addMember(MouseEvent e)throws IOException{
        if((!fName.getText().equals("")) && (!fName.getText().equals(""))){
        m.addMember(fName.getText() ,lName.getText());
        fName.setText("");
        lName.setText("");
        message.setText("Member added!");
        }
        else{
           message.setText("Please fill first and last name!");
       }
    }
    @FXML
    public void refreshMembers(MouseEvent e)throws IOException{
        ObservableList<Member> elements = FXCollections.<Member>observableArrayList();
        Member[] members = m.getMembers();
        elements.clear();
        memberList.setItems(null);
        elements.addAll(members);
        memberList.setItems(elements);
        
    }
    @FXML
    public void addWin(MouseEvent e)throws IOException{
       if((!playerId.getText().equals("")) && m.checkAccount(Integer.parseInt(playerId.getText())) ){
       m.addGame(Integer.parseInt(playerId.getText()), true);
       playerId.setText("");
       message.setText("Success!");
       }
       else{
           message.setText("Member not found!");
       }
    }
    @FXML
    public void addLoss(MouseEvent e)throws IOException{
       if((!playerId.getText().equals("")) && m.checkAccount(Integer.parseInt(playerId.getText())) ){
        m.addGame(Integer.parseInt(playerId.getText()), false);
        playerId.setText("");
        message.setText("Success!");
       }
       else{
           message.setText("Member not found!");
       }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
