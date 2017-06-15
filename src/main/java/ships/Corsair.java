package ships;

import constants.PirateConstants;
import mediators.GreatMediator;
import utils.Position;

import javafx.scene.paint.Color;

public class Corsair extends RobbingShip {

   private final static int BOUND_ATTACK = 30;
   private final static int BOUND_HP_MAX = 100;
   private final static int BOUND_CAPACITY = 100;
   private final static int BOUND_SPEED = 5;
   private final static int BOUND_RANGE_VIEW = 5;

   public Corsair(GreatMediator mediator, Position position) {
      super(mediator, position);
   }

   @Override
   protected int getMaxAttack() {
      return BOUND_ATTACK;
   }

   @Override
   public int getMaxHP() {
      return BOUND_HP_MAX;
   }

   @Override
   public int getMaxCapacity() {
      return BOUND_CAPACITY;
   }

   @Override
   public int getMaxSpeed() {
      return BOUND_SPEED;
   }

   @Override
   public int getMaxRangeView() {
      return BOUND_RANGE_VIEW;
   }


   @Override
   public Color getColor(){ return Color.MAGENTA; }

   @Override
   public void run() {
      if (treasure == capacity) {
         mediator.wantToDeposit(this);
      } else {
         mediator.wantToAttack(this);
      }
   }

   @Override
   public Position getBase() {
      return new Position(0 ,PirateConstants.MAP_HEIGHT / 2);
   }
}
