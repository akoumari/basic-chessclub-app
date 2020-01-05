/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication6;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javafxapplication6.FXMLDocumentController.m;

/**
 * FXML Controller class
 *
 * @author alexk
 */
public class ReportingServicesController implements Initializable {
    @FXML public ListView<Member> memberList;
    @FXML public ListView<String> bestList;
    @FXML public ListView<String> winList;
    @FXML
    public void backToMain(MouseEvent e)throws IOException{
        Parent viewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene otherScene = new Scene(viewParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(otherScene);
    }
    @FXML
    public void refresh(MouseEvent e)throws IOException{
        ObservableList<Member> mem = FXCollections.<Member>observableArrayList();
        Member[] members = m.getMembers();
        mem.addAll(members);
        memberList.setItems(mem);    
        ObservableList<String> best = FXCollections.<String>observableArrayList();
        String[] bests = m.getBestPlayer();
        best.addAll(bests);
        bestList.setItems(best); 
        ObservableList<String> win = FXCollections.<String>observableArrayList();
        String[] wins = m.getMostWinner();
        win.addAll(wins);
        winList.setItems(win); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
