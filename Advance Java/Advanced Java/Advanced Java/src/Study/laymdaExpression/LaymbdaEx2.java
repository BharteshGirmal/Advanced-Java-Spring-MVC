package Study.laymdaExpression;

import java.util.Comparator;
import java.util.TreeSet;

public class LaymbdaEx2 
{
	public static void main(String[] args) 
	{
		Comparator<Student> cmp=(o1,o2)->{
			if(o1.roll < o2.roll) return 1;
			if(o1.roll > o2.roll) return -1;
			else
				return 0;
		};
		
		TreeSet<Student> set= new TreeSet<Student>();
		 	set.add(new Student(12,"Bhartesh"));
		 	set.add(new Student(2,"Akshay"));
		 	set.add(new Student(1,"Hardik"));
		 	set.add(new Student(5,"Pankaj"));
		 	set.add(new Student(3,"shubham"));
		 	set.add(new Student(9,"Pratik"));
		 	
		 	for(Student Stud : set)
		 		System.out.println(Stud);
	}

}

class Student implements Comparable<Student>
{
	int roll;
	String Name;
	
	Student(int r , String n)
	{
		roll=r;
		Name=n;
	}
	
	@Override
	public String toString() 
	{
		return "Name: "+Name+"\nRoll:"+roll; 
	}

	@Override
	public int compareTo(Student o) 
	{
		// TODO Auto-generated method stub
		return this.Name.compareTo(o.Name);
	}
	
}
