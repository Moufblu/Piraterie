package ships;

import mediators.GreatMediator;

public class Merchant extends Ship
{
   protected Merchant(GreatMediator mediator, int capacity, int speed, int rangeView)
   {
      super(mediator, capacity, speed, rangeView);
   }

   @Override
   void move()
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
   public void deposit()
   {
      
   }
   
   public void collect(int money)
   {
      
   }
}
