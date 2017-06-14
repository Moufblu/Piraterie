package ch.heigvd.piraterie;

import constants.PirateConstants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import mediators.GreatMediator;
import ships.Ship;

import javax.imageio.ImageIO;
import javafx.scene.paint.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

import static constants.PirateConstants.*;
import static constants.PirateConstants.terrainType.*;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane gamePane;



    public PirateConstants.terrainType[][] terrainMatrix = new PirateConstants.terrainType[PirateConstants.MAP_WIDTH][PirateConstants.MAP_HEIGHT];
    private GreatMediator greatMediator;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //gamePane.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        BufferedImage map = null;
        try{
            map = ImageIO.read(new java.io.File("src/main/resources/img/example_map.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //On rempli la matrice de terrain
        for( int i = 0; i < terrainMatrix.length; i++ ) {
            for (int j = 0; j < terrainMatrix[0].length; j++) {
                int rgb = map.getRGB(i,j);
                if(rgb == DEEP_WATER_COLOUR){
                    terrainMatrix[i][j] = DEEP_WATER;
                }else if(rgb == SHALLOW_WATER_COLOUR){
                    terrainMatrix[i][j] = SHALLOW_WATER;
                }else if(rgb == START_COAST_COLOUR){
                    terrainMatrix[i][j] = START_COAST;
                }else if(rgb == END_COAST_COLOUR){
                    terrainMatrix[i][j] = END_COAST;
                }else if(rgb == PIRATE_BAY_COLOUR){
                    terrainMatrix[i][j] = PIRATE_BAY;
                }else if(rgb == FOG_COLOUR){
                    terrainMatrix[i][j] = FOG;
                }else{
                    terrainMatrix[i][j] = DEEP_WATER;
                }
            }
        }
    }

    public void updateBoats(){
        List<List<Ship>> l = greatMediator.getShips();
        for(int i = 0; i < l.size(); ++i){
            for(Ship s : l.get(i)){
                Circle temp = new Circle(s.getPosition().getX(),s.getPosition().getY(),10);
                temp.setFill(s.getColor());
                gamePane.getChildren().add(new Circle(0,0, 10));
            }
        }
    }

}
