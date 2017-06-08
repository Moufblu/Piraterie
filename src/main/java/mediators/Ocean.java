package mediators;

import java.awt.Point;

public class Ocean extends AbstractMediator
{

   public Ocean(GreatMediator greatMediator, double speedModifier) {
      super(greatMediator, speedModifier);
   }

   @Override
   void returnToBase(Point base) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
}
