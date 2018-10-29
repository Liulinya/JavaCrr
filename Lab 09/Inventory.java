import java.awt.event.*;
import javax.swing.*;
//https://www.cs.indiana.edu/classes/c212-dgerman/fall2018/lab09.html
//http://silo.cs.indiana.edu:8346/04142012/005.html
//https://www.cs.indiana.edu/classes/c212-dgerman/spr2012/classNotes/chapter10.html
  
public class Inventory extends JFrame implements ActionListener, KeyListener {
  private static final long serialVersionUID = 1L;
  
  //Step 9: add KeyListener
  public void keyPressed (KeyEvent e) { }
  public void keyReleased(KeyEvent e) { }
  public void keyTyped   (KeyEvent e) {
    result.setText("");//Resets the text in the outputLabel whenever a key is typed within the text fields
  }
  
  //Step 7-2: construct to perform an ActionEvent
  public void actionPerformed(ActionEvent e) {
    int cartons = Integer.parseInt( numberTextField1.getText());
    int items = Integer.parseInt( numberTextField2.getText());
    result.setText( " " + cartons * items);
    //.setText(" ") at the beginning can reset the text fields every time
  }
  
  //Step 8: make actionPerformed to reach this two vars
  JTextField numberTextField1, numberTextField2;
  JLabel numberLabel1, numberLabel2, totalLabel, result;
    
  public Inventory() {
    //Step 2-1: set all properties for JPanel
    JButton action;
    JPanel panel = new JPanel();
    
    panel.setLayout( null );
    
    //Step 3: add JLabel1
    numberLabel1 = new JLabel("Cartons per shipment: ");
    numberLabel1.setBounds(20, 20, 160, 20);//x axis, y axis, width, height
    panel.add(numberLabel1);
    
    //Step 4: add JTextField -> set preferred size
    numberTextField1 = new JTextField();
    //  numberTextField.setPreferredSize( new Dimension(60,20));
    numberTextField1.setBounds(160, 20, 60, 20);
    panel.add(numberTextField1);
    
    //Step 3: add JLabel2
    numberLabel2 = new JLabel("Items per carton: ");
    numberLabel2.setBounds(20, 50, 160, 20);
    panel.add(numberLabel2);
    
    //Step 4: add JTextField -> set preferred size
    numberTextField2 = new JTextField();
    //  numberTextField.setPreferredSize( new Dimension(60,20));
    numberTextField2.setBounds(160, 50, 60, 20);
    panel.add(numberTextField2);

 
    //Step 6: add total JLabel -> set preferred size
    totalLabel = new JLabel( "Total: " );
    totalLabel.setBounds(240, 20, 40, 20);
    panel.add(totalLabel);
    
    //Step 5:add JButton -> set preferred size
    action = new JButton( "Calculate Total" );
    action.setBounds(240, 50, 120, 20);
    panel.add( action );
    
    //Step 6: add total JLabel -> set preferred size
    result = new JLabel( "" );
    result.setBounds(280, 20, 40, 20);
    panel.add(result);
    
    //Step 7-1: add ActionListener
    //Add a keyListener object to each field
    //This keyListener contains a method keyPressed that clears the output when a key is entered in a field
    numberTextField1.addKeyListener( this );
    numberTextField2.addKeyListener( this );
    //This will cause the actionPerformed method to be executed whenever the button is clicked
    action.addActionListener( this );
    
    //Step 2-2: add panel
    this.add(panel);
    
    //Step 1: set basic frame
    this.setSize(400, 130);//width, height
    this.setVisible(true);
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
  public static void main(String[] args) {
    new Inventory();
    
  }
}