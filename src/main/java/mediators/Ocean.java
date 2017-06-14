package mediators;

import ships.Ship;
import utils.Point;

public class Ocean extends AbstractMediator
{

   public Ocean(double speedZone, double sightModifier) {
      super(speedZone,sightModifier);
   }

   @Override
   void move(Ship s, Point destinationPosition) {

   }
   
}
