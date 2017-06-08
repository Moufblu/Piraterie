package ships;

import mediators.AbstractMediator;

public abstract class Ship
{
   private int x, y;
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
   
   public int distanceTo(Ship s){
      return Math.abs(x - s.x) + Math.abs(y - s.y);
   }
   
   abstract void move();
}
