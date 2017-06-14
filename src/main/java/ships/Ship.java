package ships;

import mediators.GreatMediator;
import utils.Point;

public abstract class Ship
{
   private Point position;
   private final int CAPACITY;
   private final int speed;
   private final int rangeView;
   private final GreatMediator mediator;
   
   protected Ship(GreatMediator mediator, int capacity, int speed, int rangeView)
   {
      CAPACITY = capacity;
      this.speed = speed;
      this.rangeView = rangeView;
      this.mediator = mediator;
   }
   
   public int distanceTo(Ship s){
      return position.distanceTo(s.position);
   }
   
   abstract void move();

   public Point getPosition() {
      return position;
   }

   public int getSpeed() {
      return speed;
   }
   
   
}
