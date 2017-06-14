package ships;

import mediators.GreatMediator;
import utils.Position;

public class Corsair extends RobbingShip {

   private final static int BOUND_ATTACK = 10;
   private final static int BOUND_HP_MAX = 100;
   private final static int BOUND_CAPACITY = 100;
   private final static int BOUND_SPEED = 2;
   private final static int BOUND_RANGE_VIEW = 3;

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
   public double getAttackPower() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void run() {
      if (treasure == CAPACITY) {
         mediator.wantToDeposit(this);
      } else {
         mediator.wantToAttack(this);
      }
   }
}
