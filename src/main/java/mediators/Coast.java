package mediators;

import ships.Ship;
import utils.Position;

public class Coast extends AbstractMediator
{

   public Coast(double speedZone,double sightModifier) {
      super( speedZone,sightModifier);
   }

   @Override
   void move(Ship s, Position destinationPosition) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   
}
