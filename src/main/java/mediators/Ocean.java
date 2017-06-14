package mediators;

import ships.Ship;
import utils.Position;

public class Ocean extends AbstractMediator
{

   public Ocean(double speedZone, double sightModifier) {
      super(speedZone,sightModifier);
   }

   @Override
   void move(Ship s, Position destinationPosition) {

   }
   
}
