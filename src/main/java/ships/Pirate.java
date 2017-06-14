package ships;

import utils.Position;
import mediators.GreatMediator;
import javafx.scene.paint.Color;

public class Pirate extends RobbingShip {

   private final static int BOUND_ATTACK = 5;
   private final static int BOUND_HP_MAX = 100;
   private final static int BOUND_CAPACITY = 100;
   private final static int BOUND_SPEED = 4;
   private final static int BOUND_RANGE_VIEW = 5;

   public Pirate(GreatMediator mediator, Position position) {
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
   public Color getColor(){ return Color.SLATEGRAY; }


   @Override
   public void run() {
      if (treasure == CAPACITY) {
         mediator.wantToDeposit(this);
      } else {
         mediator.wantToAttack(this);
      }
   }

   @Override
   public Position getBase() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
