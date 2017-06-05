package ships;

import java.awt.Point;
import mediators.AbstractMediator;

public abstract class RobbingShip extends Ship
{
   protected final int ATTACK;
   protected int treasure;
   
   protected RobbingShip(AbstractMediator mediator, Point position)
   {
      super(mediator, position);
      ATTACK = randomBetween(1, getMaxAttack());
      treasure = 0;
   }
   
   @Override
   public void run()
   {
      if (treasure == CAPACITY)
      {
         mediator.returnToBase();
      }
      else
      {
         mediator.findTarget();
      }
   }
   
   protected abstract int getMaxAttack();

   public int getATTACK()
   {
      return ATTACK;
   }

   public int getTreasure()
   {
      return treasure;
   }
}
