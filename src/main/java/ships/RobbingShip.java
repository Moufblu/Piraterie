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

   public void setTreasure(int treasure) {
      this.treasure = treasure;
   }

   public int getAttackPower(){
      return ATTACK;
   }

   @Override
   public int getSpeed()
   {
      //S'il est trop lourd, il va moins vite
      if(treasure > getCapacity()){
         return speed/2;
      }
      return speed;
   }
}
