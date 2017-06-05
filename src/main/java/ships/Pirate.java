package ships;

import java.awt.Point;
import mediators.AbstractMediator;

public class Pirate extends RobbingShip
{
   private final static int BOUND_ATTACK = 5;
   private final static int BOUND_HP_MAX = 100;
   private final static int BOUND_CAPACITY = 100;
   private final static int BOUND_SPEED = 4;
   private final static int BOUND_RANGE_VIEW = 5;
   
   public Pirate(AbstractMediator mediator, Point position)
   {
      super(mediator, position);
   }

   @Override
   protected int getMaxAttack()
   {
      return BOUND_ATTACK;
   }

   @Override
   public int getMaxHP()
   {
      return BOUND_HP_MAX;
   }

   @Override
   public int getMaxCapacity()
   {
      return BOUND_CAPACITY;
   }

   @Override
   public int getMaxSpeed()
   {
      return BOUND_SPEED;
   }

   @Override
   public int getMaxRangeView()
   {
      return BOUND_RANGE_VIEW;
   }
}
