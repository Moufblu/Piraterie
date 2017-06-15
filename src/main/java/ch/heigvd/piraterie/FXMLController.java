package ch.heigvd.piraterie;

import constants.PirateConstants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mediators.*;
import ships.Corsair;
import ships.Merchant;
import ships.Pirate;

public class FXMLController implements Initializable
{


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
   @FXML
   private TextField treasureTextField;

       @FXML
    private ProgressBar merchantProgressBar;
    @FXML
    private ProgressBar pirateProgressBar;

    @FXML
    private Label pirateProgressLabel;
    @FXML
    private Label merchantProgressLabel;

   public PirateConstants.terrainType[][] terrainMatrix = new PirateConstants.terrainType[PirateConstants.MAP_WIDTH][PirateConstants.MAP_HEIGHT];
   private GreatMediator greatMediator;
   private int gameFPS = 30;
   private int treasureGoal;

   @Override
   public void initialize(URL url, ResourceBundle rb)
   {
      //gamePane.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
      BufferedImage map = null;
      try
      {
         map = ImageIO.read(new java.io.File("src/main/resources/img/example_map.bmp"));
      } catch (IOException e)
      {
         e.printStackTrace();
      }

      //On rempli la matrice de terrain
      for (int i = 0; i < terrainMatrix.length; i++)
      {
         for (int j = 0; j < terrainMatrix[0].length; j++)
         {
            int rgb = map.getRGB(i, j);
            if (rgb == DEEP_WATER_COLOUR)
            {
               terrainMatrix[i][j] = DEEP_WATER;
            } else if (rgb == SHALLOW_WATER_COLOUR)
            {
               terrainMatrix[i][j] = SHALLOW_WATER;
            } else if (rgb == START_COAST_COLOUR)
            {
               terrainMatrix[i][j] = START_COAST;
            } else if (rgb == END_COAST_COLOUR)
            {
               terrainMatrix[i][j] = END_COAST;
            } else if (rgb == PIRATE_BAY_COLOUR)
            {
               terrainMatrix[i][j] = PIRATE_BAY;
            } else if (rgb == FOG_COLOUR)
            {
               terrainMatrix[i][j] = FOG;
            } else
            {
               terrainMatrix[i][j] = DEEP_WATER;
            }
         }
      }

      // Les textViews ne doivent prendre que des entiers
      acceptOnlyNumbers(pirateTextField);
      acceptOnlyNumbers(corsairTextField);
      acceptOnlyNumbers(merchantTextField);
      acceptOnlyNumbers(treasureTextField);

        // On prépare les médiateurs et les bateaux avant de commencer la simulation
      startButton.setOnAction(e ->
      {
         //créer les sous-médiateurs
         List<AbstractMediator> mediators = new ArrayList<>();
         mediators.add(new Fog(0.3, 0.3));
         mediators.add(new Ocean(1, 100));
         mediators.add(new Coast(0.7, 0.8));

         //créer le mediateur
         greatMediator = new GreatMediator(mediators, terrainMatrix);
         treasureGoal = Integer.valueOf(treasureTextField.getText());

         //ajoute les bateaux au médiateur
         int nbrPirates = Integer.valueOf(pirateTextField.getText());
         for (int i = 0; i < nbrPirates; i++)
         {
            double x = PirateConstants.RANDOM.nextDouble() * PirateConstants.MAP_WIDTH;
            double y = PirateConstants.RANDOM.nextDouble() * PirateConstants.MAP_HEIGHT;
            greatMediator.add(new Pirate(greatMediator, new utils.Position(x, y)));
         }

         int nbrCorsair = Integer.valueOf(corsairTextField.getText());
         for (int i = 0; i < nbrCorsair; i++)
         {
            double x = PirateConstants.RANDOM.nextDouble() * PirateConstants.MAP_WIDTH;
            double y = PirateConstants.RANDOM.nextDouble() * PirateConstants.MAP_HEIGHT;
            greatMediator.add(new Corsair(greatMediator, new utils.Position(x, y)));
         }

         int nbrMerchants = Integer.valueOf(merchantTextField.getText());
         for (int i = 0; i < nbrMerchants; i++)
         {
            double x = PirateConstants.RANDOM.nextDouble() * PirateConstants.MAP_WIDTH;
            double y = PirateConstants.RANDOM.nextDouble() * PirateConstants.MAP_HEIGHT;
            greatMediator.add(new Merchant(greatMediator, new utils.Position(x, y)));
         }


         //loop de la simulation
         new Thread(() -> loop()).start();

      });
   }

   private void acceptOnlyNumbers(TextField tf)
   {
      tf.textProperty().addListener((observable, oldValue, newValue) ->
      {
         if (!newValue.matches("\\d*"))
         {
            tf.setText(newValue.replaceAll("[^\\d]", ""));
         }
      });
   }

   private void loop()
   {
      while (true)
      {
         try
         {
            Thread.sleep(gameFPS);
         } catch (InterruptedException ex)
         {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }

         for (List<Ship> ships : greatMediator.getShips())
         {
            for (Iterator<Ship> iterator = ships.iterator(); iterator.hasNext();)
            {
               Ship ship = iterator.next();
               if (ship.getHp() == 0)
               {
                  iterator.remove();
                  continue;
               }

               ship.run();
            }

         }

         updateBoats();
      }
   }

   /**
    * Permet de mettre à jour la position des bateaux connus par le grand médiateur
    * sur l'affichage principal du jeu.
    */
   public void updateBoats()
   {
      Platform.runLater(() ->
      {
         merchantProgressBar.setProgress(greatMediator.getMerchantTreasure()/(double)treasureGoal);
         pirateProgressBar.setProgress(greatMediator.getPirateTreasure()/(double)treasureGoal);
         merchantProgressLabel.setText(Integer.toString(greatMediator.getMerchantTreasure()));
         pirateProgressLabel.setText(Integer.toString(greatMediator.getPirateTreasure()));


         List<List<Ship>> l = greatMediator.getShips();
         gamePane.getChildren().clear();

         for (int i = 0; i < l.size(); ++i)
         {
            for (Ship s : l.get(i))
            {
               Circle temp = new Circle(s.getPosition().getX(), s.getPosition().getY(), 10);
               temp.setFill(s.getColor());
               gamePane.getChildren().add(temp);
            }
         }
      });

   }

}
