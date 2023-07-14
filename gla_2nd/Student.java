package gla_2nd;

public class Student implements Comparable<Student> {
	public Student(String s, int i) {
		// TODO Auto-generated constructor stub
		Name = s;
		Age = i;
	}
	@Override
	public String toString() {
		
		return "["+Name + " , "+Age+"]";
	}
	String Name;
	int Age;
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.Age - o.Age;
	}
}
