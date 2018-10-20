import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/* The World frame is a TOP LEVEL OBJECT, which makes a frame and adds a panel to the frame
   while BigBang is used for rendering tasks or basic action*/

class World extends JFrame{
 BigBang context;

 public World(String title){
  super(title);
  //create a game panel that creates a canvas (BigBang) for rendering the game graphics
  context = new BigBang();
  //add it to game context, add BigBang to the window (World)
  this.add(context);

  //if the close button is pressed we must exit the program
  //the following method tells the Window to close if the close button is pressed without doing anything.
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setBackground(Color.white);

  //get a reference to the content pane in the World (Window)
  //the content pane in the window is the area in the window other then the Title bar and Borders
  Container windowArea = this.getContentPane();

  //object dimensions will be used to tell the dimensions of the screen 
  Dimension Dim = new Dimension(Constants.WIDTH,Constants.HEIGHT);
  
  //set preffered sise for both BigBang and World
  windowArea.setPreferredSize(Dim);
  context.setPreferredSize(Dim);
  
  //ensure proper spacing for the window while filling all its object and make the window of the size
  this.pack();
  this.setResizable(false);
  this.setVisible(true);
 }

}
