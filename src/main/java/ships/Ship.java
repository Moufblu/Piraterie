package ships;

import mediators.AbstractMediator;

public abstract class Ship
{
   private final int CAPACITY;
   private int speed,
               rangeView;
   private AbstractMediator mediator;
   
   protected Ship(AbstractMediator mediator, int capacity, int speed, int rangeView)
   {
      CAPACITY = capacity;
      this.speed = speed;
      this.rangeView = rangeView;
      this.mediator = mediator;
   }
   
   abstract void move();
}
