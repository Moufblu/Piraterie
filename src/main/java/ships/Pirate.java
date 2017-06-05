package ships;

import mediators.AbstractMediator;

public class Pirate extends Ship
{
   protected Pirate(AbstractMediator mediator, int capacity, int speed, int rangeView)
   {
      super(mediator, capacity, speed, rangeView);
   }
   
   @Override
   void move()
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
   
}
