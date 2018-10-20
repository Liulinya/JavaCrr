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

 //if head posit is same as any other part's posit, it eats itself
 private boolean did_i_ate_myself(){
  Iterator iter = getPartsIterator();//get in iterator to self
  Part snakeHead = (Part)iter.next(); 
  Part temp_part;
  while(iter.hasNext() ){
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

 //at the end of its execution this will call the check for eating itself
 public boolean move(){
  /*the unit movement of snake in one tick or one movement is the block_size
   Dx is the change in X position, Dy is change in y position
   depending on the directions we compute the change in positions
   the following block uses ? : The conditional operator*/

  //if direction is right then set dx to Constants.block_size else if its left then set it to -1 * Constants.block_Size else zero
  int dx = ((direction == Constants.DIR_RIGHT)?Constants.block_size:((direction == Constants.DIR_LEFT)?-Constants.block_size:0));
  int dy = ((direction == Constants.DIR_DOWN)?Constants.block_size:((direction == Constants.DIR_UP)?-Constants.block_size:0));//same for on y axis
  Part head = this.Head();//reference to current head

  //the new values of head will be current top elements X & Y added with dy and dx
  int new_x = head.x + dx;
  int new_y = head.y + dy;

  //constrain the values mot greater then width or height
  new_x %= Constants.WIDTH; 
  // new_x = new_x % Constants.Width; this will make sure that new_x is always among -Constants.Width - Constants.Width
  new_y %= Constants.HEIGHT;
  /*on the other side too
    if new position < 0 then we add it with Constants
    since upper modulas operation already constrains it in the limit 
    so add the padding makes sure it is > 0*/
  new_x += ((new_x < 0)?Constants.WIDTH:0);
  new_y += ((new_y < 0)?Constants.HEIGHT:0);

  Part temp = new Part(new_x,new_y);
  this.parts.addFirst(temp);

  /*in case the snake ate its length is to be increased
    in that case the snake will not remove his tail element by doing so his length increases*/
  if( this.length <= this.parts.size() ){
   parts.removeLast();
  }
  return this.did_i_ate_myself();//check if the snake eats it self
 }
 
 //the snake ate some food and grow its size
 public void Eat(Food f){
  this.length += f.growth;
 }

 //display the snake
 public void Display(Graphics2D g1){
  //get an iterator of its parts
  Iterator iter = this.parts.iterator();
  Part temp;
  //and render each part as a rectangle one after the other
  while( iter.hasNext() ){
   temp = (Part)iter.next();
   g1.setColor(Color.blue);
   g1.fillOval(temp.x,temp.y,Constants.block_size,Constants.block_size);
   g1.setColor(Color.blue);
   g1.drawOval(temp.x,temp.y,Constants.block_size,Constants.block_size);
  }
   Part temp1 = (Part)this.Head();
   g1.setColor(Color.red);
   g1.fillOval(temp1.x,temp1.y,Constants.block_size,Constants.block_size);
   g1.setColor(Color.red);
   g1.drawOval(temp1.x,temp1.y,Constants.block_size,Constants.block_size);
 }
 


 //a method to get snake's head
 public Part Head(){
  return (Part)this.parts.getFirst();
 }

 //a method to obtain an iterator for the snake's parts
 public Iterator getPartsIterator(){
  return this.parts.iterator();
 }

 //create a snake
 public Snake(){
  this.parts = new ArrayDeque<Part>();
  this.parts.addFirst(new Part(Constants.WIDTH/2,Constants.HEIGHT/2));//add 1st element ate snake-head
 }
}