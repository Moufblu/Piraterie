package ships;

import utils.Position;
import mediators.GreatMediator;

public abstract class RobbingShip extends Ship
{
   protected final int ATTACK;
   protected int treasure;
   
   protected RobbingShip(GreatMediator mediator, Position position)
   {
      super(mediator, position);
      ATTACK = randomBetween(1, getMaxAttack());
      treasure = 0;
   }
   
   protected abstract int getMaxAttack();

   public int getTreasure()
   {
      return treasure;
   }
   
   public double getAttackPower(){
      return ATTACK;
   }
}
