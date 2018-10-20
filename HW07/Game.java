import java.util.*;
import java.awt.*;
import java.awt.event.*;

class Game{
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

 public boolean isOver(){
  return Game_Over;
 }

 public void handleKeyDown( KeyEvent e ){
  int key = (e.getKeyCode());
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

 public void Display(Graphics2D g2){
  player.Display(g2);
  for( int i = 0; i < Constants.MAX_NUM_FOOD; i ++ ){
   foods[i].Display(g2);
  }
  g2.drawString(("Score : " + this.score),Constants.WIDTH- 100,Constants.HEIGHT);
 }

 public void tick(){
  if(!this.Game_Over){
    this.Game_Over = this.player.move();
    for( int i = 0; i < Constants.MAX_NUM_FOOD; i ++ ){
     if(this.foods[i].isConsumed(this.player)){
      this.player.Eat(this.foods[i]);
      this.score ++;
      this.foods[i] = new Food(this.player);
     }
    }
  }else{
   System.out.println("I ate myself");
  }
 }
}