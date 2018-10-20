import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

class BigBang extends JPanel implements ActionListener{
 private boolean is_over;
 public Game game;
 private Timer t;

 public void paint_game(Graphics2D g2){
  if( this.game != null ){
   this.game.Display(g2);
  }
 }

 public void paint_game_over(Graphics2D g2){
  g2.drawString("Game Over",Constants.WIDTH/2 - 60,Constants.HEIGHT/2-5);
 }

 public void paint(Graphics win){
  super.paint(win);
  Graphics2D g2 =(Graphics2D) win;
  
  this.paint_game(g2);
   
  if( is_over ){
   this.paint_game_over(g2);
  }
  Toolkit.getDefaultToolkit().sync();
  win.dispose();
 }

 public void actionPerformed(ActionEvent e) {
  if( this.game != null && !is_over ){
   this.game.tick();
   is_over = this.game.isOver();
  }
   this.repaint();
    }

    private class KeyBoardAgent extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            game.handleKeyDown(e);
        }
    }
    
    BigBang(){
  this.setFocusable(true);
  this.addKeyListener(new KeyBoardAgent());

     Timer timer = new Timer(50, this);
     timer.start();
 }
}