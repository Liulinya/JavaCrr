import java.util.*;

public class Six{
	public static void main (String[] args){
		while (true){
			System.out.println("Please enter a number ...");
			Scanner in = new Scanner(Systems.in);
			String s = in.nextLine();
			try{
				int n = Integer.parseInt(s);
				int sqrt = Math.sqrt(n);
				System.out.println("The squared root of this number is "+sqrt);
				break;
			} catch (Exception e){
				System.out.println("This is not a number. Please input a number instead";)
			}
		}
	}
}

//no error