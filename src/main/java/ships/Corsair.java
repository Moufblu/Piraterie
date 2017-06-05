package ships;

import mediators.AbstractMediator;

public class Corsair extends Ship implements Attacker
{
   protected Corsair(AbstractMediator mediator, int capacity, int speed, int rangeView)
   {
      super(mediator, capacity, speed, rangeView);
   }

   @Override
   void move()
   {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void attack() {

   }
}
