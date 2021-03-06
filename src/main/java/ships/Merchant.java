package ships;

import constants.PirateConstants;
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
   public int getTreasure()
   {
      return CAPACITY;
   }

   @Override
   public Color getColor(){ return Color.ORANGE; }

   @Override
   public Position getBase() {
      return new Position(PirateConstants.MAP_WIDTH - 1, PirateConstants.MAP_HEIGHT / 2);
   }

   @Override
   public Position getSpawn()
   {
      return new Position(0 ,randomBetween(PirateConstants.MAP_HEIGHT/2-(PirateConstants.MAP_HEIGHT/4),PirateConstants.MAP_HEIGHT/2+(PirateConstants.MAP_HEIGHT/4)));
   }
   
   
}
