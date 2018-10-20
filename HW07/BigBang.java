/* BigBang is a class with extends JPanel in Swing
which allows you to create high performance GUI apps with swing's single threaded model
where to draw graphics are then display on screen */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;


class BigBang extends JPanel implements ActionListener{
 private boolean is_over; //check if game over or not
 public Game game;//refer to the game class
 private Timer t; 

 public void paint_game(Graphics2D g2){//paint the game
  if( this.game != null ){
   //call the function to display the game , if game is not null
   //since we assign the game externally , it can be null
   this.game.Display(g2);
  }
 }

 //paint Game Over text after game is over
 public void paint_game_over(Graphics2D g2){
  g2.drawString("Game Over",Constants.WIDTH/2 - 60,Constants.HEIGHT/2-5);
 }

 /*over-ridden method 
  JPanel class has a method called paint called automatically with current graphics context every time the window is to be rendered
  when this method is called, it passes it a Graphic Pointer, which allows you to draw objects
  the Graphics Pointer points to the current Panel of the screen which you will draw on
  initially its blank so we have to manually draw each things
  this helps since we don't have to explicitely clear them*/
 public void paint(Graphics win){
  super.paint(win);//call super class paint, clean the panel, etc
  Graphics2D g2 =(Graphics2D) win;//convert Graphics to Graphics2D to draw shapes and other methods
  
  //Even if the game is over, the game graphics will be printed to show the last state of the game
  this.paint_game(g2);
   
  if( is_over ){
   this.paint_game_over(g2);
  }
  
  Toolkit.getDefaultToolkit().sync();
      win.dispose();//dispose off the events: if not called, the paint finished or not is unknown
 }

 //an event listener listens to our timer and perform game logic
 public void actionPerformed(ActionEvent e) {
  if( this.game != null && !is_over ){
   //calls the tick method of game, which tells the game to update its state
   //ie : move the snake and see if it has ate food if so create new food
   this.game.tick();
   //check if the game was over in the last tick.\
   is_over = this.game.isOver();
  }
   this.repaint();//repaint the game
    }

    private class KeyBoardAgent extends KeyAdapter {
        public void keyReleased(KeyEvent e) {//do nothing
        }

        public void keyPressed(KeyEvent e) {//if key is pressed then handle changes
            game.handleKeyDown(e);
        }
    }
    
    BigBang(){
     this.setFocusable(true);//allows us to listen keyboard events
     
  /*add a key listener, which will call our keyboard methods -> pass it as a new KeyBoardAgent
    when press any key, it will call the KeyPressed method in KeyBoardAgent
    when release the key it will call the KeyReleased Method in the KeyBoardAgent;*/
     this.addKeyListener(new KeyBoardAgent());

     /*create a timer and call an action <our actionPerformed Method> every 50 seconds (50 is the delay parameter)
     we call our actionListener which is the function which performs our game logic every 0.050 s , 
     which allows us to make the game playable as well as the game doesnt hangs
     the game simply renders in 1ms or even less being so simple
     the rest time its free and allows us to listen key events on single thread supporting the swing architecture*/
     Timer timer = new Timer(50, this);
     timer.start();
 }
}