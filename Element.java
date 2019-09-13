
public class Element<K,T> {
	T student_obj;
	K student_key;
	String first;
	public Element()
	{
		student_obj=null;
		student_key=null;
		first="";
	}
	public Element(T o, K k, String f)
	{
		student_obj=o;
		student_key=k;
		first=f;
	}
}
