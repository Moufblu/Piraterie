package mediators;

import java.awt.Point;

public class Coast extends AbstractMediator
{

   public Coast(GreatMediator greatMediator, double speedModifier) {
      super(greatMediator, speedModifier);
   }

   @Override
   void returnToBase(Point base) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
}
