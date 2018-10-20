//a food object has a position (x,y) and a growth of food, which refers how much the snake eats and the length of snake
//a special constructor generates the food away from the snake

import java.util.*;
import java.awt.*;
import java.awt.geom.*;

class Food{
 public int x;
 public int y;
 public int growth;

 private void randomize(){//random data for the food
  this.x = (int )(Math.random() * (Constants.GAME_WIDTH));
  this.y = (int )(Math.random() * (Constants.GAME_HEIGHT));
  this.growth = (int)(Math.random() * (Constants.MAX_GROWTH_FOOD)) + 1; 
 }

 //a collision detection: if two objs collide then the abs diff of their psitn cords < width of smaller obj
 private boolean coll_det(int x,int y){
  return (Math.abs(x - this.x) < Constants.block_size && Math.abs(y - this.y) < Constants.block_size);
 }

 //default constructor
 public Food(){
  this.randomize();
 }

 //parameterized constructor: avoid generating food near the snake
 public Food( Snake s){
  boolean collision = false;

  //generate a food once then checks for collision
  //if collision occurs, re-create food and check for collision in snake body 
  //continue checking until food doesn't overlap snake
  do{
   collision = false;
   this.randomize();//generate food

   //obtain an iterator for snake's parts
   Iterator snakerator = s.getPartsIterator();
   Part part;
   //iterate over all the parts to see if new point is over some of the snake part
   while( snakerator.hasNext() ){
    part = (Part)snakerator.next();
    collision = this.coll_det( part.x, part.y );
    if( collision ){break;}
   }
  }while(collision);
 }

 //check whether the food eaten
 public Boolean isConsumed(Snake s){
  Part snakeHead = s.Head();
  //if the snake head collides with the food, then food is consumed
  if(this.coll_det( snakeHead.x, snakeHead.y )){
   return true;
  }
  return false;
 }

 //display food: plot an oval at its position
 public void Display(Graphics2D g2){
  g2.setColor(Color.yellow);
  g2.fillOval( this.x, this.y, Constants.block_size, Constants.block_size );
  g2.setColor(Color.yellow);
  g2.drawOval( this.x, this.y, Constants.block_size, Constants.block_size );
 }
}
