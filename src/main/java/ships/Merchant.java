package ships;

import mediators.AbstractMediator;

public class Merchant extends Ship
{
   protected Merchant(AbstractMediator mediator, int capacity, int speed, int rangeView)
   {
      super(mediator, capacity, speed, rangeView);
   }

   @Override
   void move()
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
   public void wantTodeposit()
   {
      
   }
   
   public void wantToCollect(int money)
   {
      
   }
}
