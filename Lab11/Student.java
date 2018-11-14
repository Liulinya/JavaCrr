import java.util.*;

public class Student{
	String name;
	int age;
	
	public Student (String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return this.name + ": " + this.age;
	}
	
	public static void main (String[] args){
		ArrayList<Student> students = new ArrayList<Students>;
		students.add(new Student("Lesley",10));
		students.add(new Student("Mike",13));
		students.add(new Student("Amy",9));
		Collections.sort(students, new Ascending());
		Systems.out.println(students);
	}
}

import java.util.*;

public class Ascending implements Comparator<Student>{
	String name;
	int age;
	public int compare(Student a, Student b){
		if (a.age > b.age) return 1;
		else if (a.age < b.age) return -1;
		else return a.name.toCompare(b.name);
	}
}

//No error