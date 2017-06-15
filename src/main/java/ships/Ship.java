package ships;

import constants.PirateConstants;
import javafx.scene.paint.Color;
import constants.PirateConstants;
import mediators.GreatMediator;
import utils.Position;

public abstract class Ship
{
   protected final int max_hp;
   protected int hp;

   protected final int capacity;
   
   protected int speed;
   protected int rangeView;
   protected Position position;
   
   protected final GreatMediator mediator;
   
   protected Ship(GreatMediator mediator, Position position)
   {
      max_hp = randomBetween(1, getMaxHP());
      hp = max_hp;
      capacity = randomBetween(1, getMaxCapacity());
      this.speed = randomBetween(1, getMaxSpeed());
      this.rangeView = randomBetween(1, getMaxRangeView());
      this.mediator = mediator;
      this.position = position;
   }
   
   public double distanceTo(Ship s){
      return position.distanceTo(s.position);
   }

   protected static int randomBetween(int min, int max)
   {
      if (min == max)
         return min;

      if(min > max){
         int temp = min;
         min = max;
         max = temp;
      }
      
      return PirateConstants.RANDOM.nextInt(max - min) + min;
   }
   
   public abstract void run();
   public abstract int getMaxHP();
   public abstract int getMaxCapacity();
   public abstract int getMaxSpeed();
   public abstract int getMaxRangeView();

   public int getHp()
   {
      return hp;
   }

   public int getSpeed()
   {
      return speed;
   }

   public int getRangeView()
   {
      return rangeView;
   }

   public int getCapacity()
   {
      return capacity;
   }
   
   public Position getPosition()
   {
      return position;
   }

   public abstract Color getColor();
   
   public void setPosition(Position newPosition) {
      position = newPosition;
   }

   public void setHp(int hp) {
      this.hp = hp;
   }

   abstract public Position getBase();
   
   public Position getSpawn(){
      return getBase();
   }

   public abstract int getTreasure();
}
