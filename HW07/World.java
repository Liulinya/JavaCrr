import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;


class World extends JFrame{
 BigBang context;

 public World(String title){
  super(title);
  context = new BigBang();
  this.add(context);

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setBackground(Color.white);
  
  Container windowArea = this.getContentPane();

  Dimension Dim = new Dimension(Constants.WIDTH,Constants.HEIGHT);
  
  windowArea.setPreferredSize(Dim);
  context.setPreferredSize(Dim);
  
  this.pack();

  this.setResizable(false);

  this.setVisible(true);
 }

}
