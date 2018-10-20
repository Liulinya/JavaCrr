//snake + its parts
import java.util.*;
import java.awt.*;
import java.awt.geom.*;

//snake part's position: each part of a snake has an x and y value
class Part{
 public int x;
 public int y;
 Part(int x,int y){
  this.x = x;
  this.y = y;
 }
}

//snake is a double ended queue of parts, with a field direction and length
class Snake{
 private int length = 10;
 private ArrayDeque<Part> parts;
 private int direction = 0;

 //If head posit is same as any other part's posit, it eats itself
 private boolean did_i_ate_myself(){
  Iterator iter = getPartsIterator();//get in iterator to self
  Part snakeHead = (Part)iter.next(); 
  Part temp_part;
  while( iter.hasNext() ){
   temp_part = (Part)iter.next();//get a part
   //check if collision
   if( Math.abs(temp_part.x - snakeHead.x) < Constants.block_size &&
    Math.abs(temp_part.y - snakeHead.y ) < Constants.block_size)
   {return true;//it ate itself, game over
   }
  }
  return false;
 }

 public void setDirection(int dir){
  this.direction = dir;
 }

 public boolean move(){
  int dx = ((direction == Constants.DIR_RIGHT)?Constants.block_size:((direction == Constants.DIR_LEFT)?-Constants.block_size:0));
  int dy = ((direction == Constants.DIR_DOWN)?Constants.block_size:((direction == Constants.DIR_UP)?-Constants.block_size:0));
  Part head = this.Head();

  int new_x = head.x + dx;
  int new_y = head.y + dy;

  new_x %= Constants.WIDTH;
  new_y %= Constants.HEIGHT;
  new_x += ((new_x < 0)?Constants.WIDTH:0);
  new_y += ((new_y < 0)?Constants.HEIGHT:0);

  Part temp = new Part(new_x,new_y);
  this.parts.addFirst(temp);

  if( this.length <= this.parts.size() ){
   parts.removeLast();
  }
  return this.did_i_ate_myself();
 }
 public void Eat(Food f){
  this.length += f.growth;
 }

 public void Display(Graphics2D g2){
  Iterator iter = this.parts.iterator();
  Part temp;
  while( iter.hasNext() ){
   temp = (Part)iter.next();
   g2.drawRect(temp.x,temp.y,Constants.block_size,Constants.block_size);
  }
 }

 public Part Head(){
  return (Part)this.parts.getFirst();
 }

 public Iterator getPartsIterator(){
  return this.parts.iterator();
 }

 public Snake(){
  this.parts = new ArrayDeque<Part>();
  this.parts.addFirst(new Part(Constants.WIDTH/2,Constants.HEIGHT/2));
 }
}
