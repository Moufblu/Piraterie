package ships;

import utils.Point;
import mediators.GreatMediator;

public abstract class RobbingShip extends Ship
{
   protected final int ATTACK;
   protected int treasure;
   
   protected RobbingShip(GreatMediator mediator, Point position)
   {
      super(mediator, position);
      ATTACK = randomBetween(1, getMaxAttack());
      treasure = 0;
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
   
   public abstract double getAttackPower();
}
