package mediators;

import ships.Ship;
import utils.Point;

public class Coast extends AbstractMediator
{

   public Coast(double speedModifier) {
      super( speedModifier);
   }

   @Override
   void move(Ship s, Point destinationPosition) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   
}
