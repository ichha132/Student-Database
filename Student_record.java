
public class Student_record implements Student {
	String first;
	String last;
	String hostel;
	String department;
	String cgpa;
	public Student_record(String f, String l, String h, String d, String c)
	{
		first=f;
		last=l;
		hostel=h;
		department=d;
		cgpa=c;
	}
	public String fname()
	{
		return first;// Return studentís first name 
	}
	public String lname()      // Return studentís last name
	{
		return last;
	}
	public String hostel()     // Return studentís hostel name
	{
		return hostel;
	}
	public String department()
	{
		return department;// Return studentís department name 
	}
	public String cgpa()
	{
		return cgpa;	// Return studentís cgpa 
	}
	public String toString()
	{
		return this.first;
	}
//	@Override
//	public int compareTo(T obj) {
//		// TODO Auto-generated method stub
//		String s1=this.first;
//		String s2=obj.first;
//		return s1.compareTo(s2);
//	}
}

