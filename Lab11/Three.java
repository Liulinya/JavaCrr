import javax.swing.*;
import java.awt.event.*;

public class Three implements ActionListener {
//public class Three extends JFrame implements ActionListener {
	public static void main (String[] args){
		Three a = new Three();
		//JFrame a = new Three();
		Timer timer = new Timer(1000, a);
		timer.start();
	}
	
	int count = 0;
	public void actionPerformed(ActionEvent e){
		this.count += 1;
		System.out.println("I called "+this.count+" times");
	}
	
/*	public Three(){
		this.setVisible(true);
		this.setSize(200,400);
	}*/
}

//Error: JFrame cannot be converted to ActionListener
//Points deducted: 10