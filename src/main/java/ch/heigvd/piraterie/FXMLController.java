package ch.heigvd.piraterie;

import constants.PirateConstants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import mediators.GreatMediator;
import ships.Ship;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

import static constants.PirateConstants.*;
import static constants.PirateConstants.terrainType.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mediators.*;
import ships.Corsair;
import ships.Merchant;
import ships.Pirate;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private AnchorPane gamePane;

    @FXML
    private Button startButton;
    
    @FXML
    private TextField merchantTextField;
    @FXML
    private TextField pirateTextField;
    @FXML
    private TextField corsairTextField;

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
        
        startButton.addActionListener ((ActionEvent e) ->
        {
           Random RANDOM = new Random(); //à changer avec le constant global
           
           //créer les sous-médiateurs
           List<AbstractMediator> mediators = new ArrayList<>();
           mediators.add(new Coast(1.5, 0.8));
           mediators.add(new Ocean(3, 1));
           mediators.add(new Fog(0.5, 0.2));
           
           //créer le mediateur
           greatMediator = new GreatMediator(mediators);
           
           //ajoute les bateaux au médiateur
           int nbrPirates = Integer.valueOf(pirateTextField.getText());
           for (int i = 0; i < nbrPirates; i++)
           {
              double x = RANDOM.nextDouble() * PirateConstants.MAP_HEIGHT;
              double y = RANDOM.nextDouble() * PirateConstants.MAP_WIDTH;
              greatMediator.add(new Pirate(greatMediator, new utils.Point((int)x, (int)y)));
           }
           
           int nbrCorsair = Integer.valueOf(corsairTextField.getText());
           for (int i = 0; i < nbrCorsair; i++)
           {
              double x = RANDOM.nextDouble() * PirateConstants.MAP_HEIGHT;
              double y = RANDOM.nextDouble() * PirateConstants.MAP_WIDTH;
              greatMediator.add(new Corsair(greatMediator, new utils.Point((int)x, (int)y)));
           }
           
           int nbrMerchants = Integer.valueOf(merchantTextField.getText());
           for (int i = 0; i < nbrMerchants; i++)
           {
              double x = RANDOM.nextDouble() * PirateConstants.MAP_HEIGHT;
              double y = RANDOM.nextDouble() * PirateConstants.MAP_WIDTH;
              greatMediator.add(new Merchant(greatMediator, new utils.Point((int)x, (int)y)));
           }
           
           //loop de la simulation
           loop();
           
        });
    }
    
    private void loop()
    {
       greatMediator.getShips().stream().forEach((ships) ->
       {
          ships.stream().forEach((ship) ->
          {
             ship.run();
          });
       });
       
       updateBoats();
    }

    public void updateBoats(){
        for(List<Ship> l : greatMediator.getShips()){
            
        }
    }

}
