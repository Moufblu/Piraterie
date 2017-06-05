package ships;

import java.awt.Point;
import java.util.Calendar;
import java.util.Random;
import mediators.AbstractMediator;

public abstract class Ship
{   
   protected final int MAX_HP;
   protected int hp;
   
   protected final int CAPACITY;
   
   protected int speed;
   protected int rangeView;
   protected Point position;
   
   protected AbstractMediator mediator;
   
   private static final Random rand = new Random();
   
   protected Ship(AbstractMediator mediator, Point position)
   {
      MAX_HP = randomBetween(1, getMaxHP());
      hp = MAX_HP;
      CAPACITY = randomBetween(1, getMaxCapacity());
      this.speed = randomBetween(1, getMaxSpeed());
      this.rangeView = randomBetween(1, getMaxRangeView());
      this.mediator = mediator;
      this.position = position;
   }
   
   protected static int randomBetween(int min, int max)
   {
      return rand.nextInt(max - min) + min;
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

   public int getCAPACITY()
   {
      return CAPACITY;
   }
   
   public Point getPosition()
   {
      return position;
   }
   
   
}
