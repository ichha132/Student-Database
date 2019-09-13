
public class Pair implements Pair_ {
	String first_name;
	String last_name;
	public Pair(String f1, String l1)
	{
		first_name=f1;
		last_name=l1;
	}

	public String f() {
		// TODO Auto-generated method stub
		return first_name;
	}

	public String l() {
		// TODO Auto-generated method stub
		return last_name;
	}
	public String toString()
	{
		String str=this.first_name+" "+this.first_name+this.last_name;
		return str;
	}
}
