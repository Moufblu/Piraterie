package mediators;

import java.awt.Point;

public class Fog extends AbstractMediator
{

   public Fog(GreatMediator greatMediator, double speedModifier) {
      super(greatMediator, speedModifier);
   }

   @Override
   void returnToBase(Point base) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
}
