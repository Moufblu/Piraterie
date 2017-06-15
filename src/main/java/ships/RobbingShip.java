package ships;

import utils.Position;
import mediators.GreatMediator;

public abstract class RobbingShip extends Ship
{
   protected final int attack;
   protected int treasure;
   
   protected RobbingShip(GreatMediator mediator, Position position)
   {
      super(mediator, position);
      attack = randomBetween(1, getMaxAttack());
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
      return attack;
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
