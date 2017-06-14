package ch.heigvd.piraterie;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane gamePane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gamePane.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
    }    
}
