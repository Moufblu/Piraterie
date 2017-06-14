package ships;

import mediators.GreatMediator;

public class Corsair extends Ship implements Attacker
{
   protected Corsair(GreatMediator mediator, int capacity, int speed, int rangeView)
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
