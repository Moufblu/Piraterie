package ships;

import utils.Point;
import mediators.GreatMediator;

import javafx.scene.paint.Color;

public class Merchant extends Ship
{
   private final static int BOUND_HP_MAX = 100;
   private final static int BOUND_CAPACITY = 100;
   private final static int BOUND_SPEED = 2;
   private final static int BOUND_RANGE_VIEW = 3;
   
   public Merchant(GreatMediator mediator, Point position)
   {
      super(mediator, position);
   }

   @Override
   public void run()
   {
      mediator.wantToDeposit(this);
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

   @Override
   public Color getColor(){ return Color.YELLOW; }

}
