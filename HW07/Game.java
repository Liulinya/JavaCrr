import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Game{//game logic
 private boolean Game_Over;
 private int score;
 private Snake player;
 private Food[] foods;

 public Game(){
  this.player = new Snake();
  this.foods = new Food[Constants.MAX_NUM_FOOD];
  for( int i = 0; i < Constants.MAX_NUM_FOOD; i ++ ){
   this.foods[i] = new Food(this.player);
  }
 }

 //check if the game over
 public boolean isOver(){
  return Game_Over;
 }

 //eventlistener for handling keys
 public void handleKeyDown( KeyEvent e ){
  //get which key was pressed to fire this event
  int key = (e.getKeyCode());
  // This would look better with a switch
  // The code is self explanatiory
  // VK_<XYZ> are special values for assigning keys
  // They are predefined in Java!
  if( key == KeyEvent.VK_LEFT ){
   this.player.setDirection(Constants.DIR_LEFT);
  }
  if( key == KeyEvent.VK_DOWN ){
   this.player.setDirection(Constants.DIR_DOWN);
  }
  if( key == KeyEvent.VK_UP ){
   this.player.setDirection(Constants.DIR_UP);
  }
  if( key == KeyEvent.VK_RIGHT ){
   this.player.setDirection(Constants.DIR_RIGHT);
  }
 }

 public void Display(Graphics2D g3){//display the game
  player.Display(g3);//display the snake
  for( int i = 0; i < Constants.MAX_NUM_FOOD; i ++ ){
   foods[i].Display(g3);//display the food
  }
  g3.setColor(Color.black);
  g3.drawString(("Score : " + this.score),Constants.WIDTH- 100,Constants.HEIGHT);
 }

 /* tick is a unit execution of game logic,
    each tick is a unit change in the game's world
    a tick is more or less an event that occurs
    every n seconds where n < 1 
    because of this the positions of objects change*/
 public void tick(){//do it only if the game is not over
  if(!this.Game_Over){
    this.Game_Over = this.player.move();//move the snake
    for( int i = 0; i < Constants.MAX_NUM_FOOD; i ++ ){//check if the snake eating
     if(this.foods[i].isConsumed(this.player)){
      this.player.Eat(this.foods[i]);
      this.score ++;
      this.foods[i] = new Food(this.player);
     }
    }
  }
  else{System.out.println("I ate myself");}
 }
}