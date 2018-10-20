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

 // This method is used to move the snake
 // At the end of its execution this will call the check
 // for eating itself
 // this is more or less shortand
 // since we need to check the rules after every move
 // we call the did i ate myself from the move function
 public boolean move(){
  // The unit movement of snake in one tick
  // or one movement is the block_size.
  // Dx is the change in X position
  // Dy is change in y position
  // Depending on the directions we compute the change in positions
  // The following block uses ? : The conditional operator

  // If Direction is Right then set dx to Constants.block_size else if its left then set it to -1 * Constants.block_Size else zero;
  int dx = ((direction == Constants.DIR_RIGHT)?Constants.block_size:((direction == Constants.DIR_LEFT)?-Constants.block_size:0));
  // Same as above line but on y axis
  int dy = ((direction == Constants.DIR_DOWN)?Constants.block_size:((direction == Constants.DIR_UP)?-Constants.block_size:0));
  // Get a reference to the current head
  Part head = this.Head();

  // temporary new values
  // of x and y
  // The new values of head will be current top elements X & Y
  // added with dy and dx;

  int new_x = head.x + dx;
  int new_y = head.y + dy;

  // Constrain the values
  // We dont want a value greater then Width at any case
  // we dont want a value greter then height at any case.
  new_x %= Constants.WIDTH; // new_x = new_x % Constants.Width; this will make sure that new_x is always among -Constants.Width - Constants.Width
  new_y %= Constants.HEIGHT;
  // on the other side too
  // If the new position is lower then Zero then we add it with Constants
  // Since upper modulas operation already constrains it in the limit hence
  // adding the padding makes sure it is > 0;
  new_x += ((new_x < 0)?Constants.WIDTH:0);
  new_y += ((new_y < 0)?Constants.HEIGHT:0);

  // Add my new head... basically its just adding
  // the new coordinate as the top of Deque
  Part temp = new Part(new_x,new_y);
  this.parts.addFirst(temp);

  // If i am growing why pop ?
  // In case the snake ate his length is to be increased
  // In that case the snake will not remove his tail element
  // by doing so his length increases.
  if( this.length <= this.parts.size() ){
   parts.removeLast();
  }
  //check if the movement caused a disaster
  return this.did_i_ate_myself(); // Oh noes on that.. but well game will be over
 }
 public void Eat(Food f){
  //the snake ate some food
  //so it will now grow in size
  this.length += f.growth;
 }

 //display the snake
 public void Display(Graphics2D g2){
  //get an iterator of its parts
  Iterator iter = this.parts.iterator();
  Part temp;
  //and render each part as a rectangle one after the other
  while( iter.hasNext() ){
   temp = (Part)iter.next();
   g2.drawRect(temp.x,temp.y,Constants.block_size,Constants.block_size);
  }
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