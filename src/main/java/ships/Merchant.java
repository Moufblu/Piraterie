package ships;

import utils.Position;
import mediators.GreatMediator;

import javafx.scene.paint.Color;

public class Merchant extends Ship
{
   private final static int BOUND_HP_MAX = 100;
   private final static int BOUND_CAPACITY = 100;
   private final static int BOUND_SPEED = 1;
   private final static int BOUND_RANGE_VIEW = 3;
   
   public Merchant(GreatMediator mediator, Position position)
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

   @Override
   public Position getBase() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
