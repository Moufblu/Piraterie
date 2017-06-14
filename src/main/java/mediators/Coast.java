package mediators;

import constants.PirateConstants;
import ships.Ship;
import utils.Position;


public class Coast extends AbstractMediator
{

   public Coast(double speedZone,double sightModifier) {
      super( speedZone,sightModifier);
   }  

}
