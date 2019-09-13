import java.lang.Math;
public class Double_Hashing<K,T> implements MyHashTable_<K, T> {
	Element<K,T> hashtable[];
	int N;
	@SuppressWarnings("unchecked")
	public Double_Hashing(int N)
	{
		this.N=N;
		hashtable=new Element[N];
	}
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
	//import java.lang.Math; 
	public static long sdbm(String str, int hashtableSize) { 
	    long hash = 0; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash; 
	    } 
	    return Math.abs(hash) % (hashtableSize - 1) + 1; 
	}
	@Override
	public int insert(K key, T obj) {
		// TODO Auto-generated method stub
		String str=key.toString();
		String s1="";
		int j;
		for( j=0;str.charAt(j)!=' ';j++)
		{
		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		String s2=obj.toString();
		int x;
		int i=0;
		long h1=djb2(s1,N);
		long h2=sdbm(s1,N);
		int c=0;
		x= (int) ((h1+ h2*i)% N);
		c=c+1;
		System.out.println(x);
		while(hashtable[x]!=null)
		{
			if(hashtable[x].first.equals("*"))
				break;
			else
			{
				
				i=i+1;
				x= (int) ((h1+ h2*i)% N);
				System.out.println(x);
				c=c+1;
			}
		}
		hashtable[x]= new Element(obj,key,obj.toString());
		//System.out.println(x);
		//System.out.println("hash 2 i="+ (i+1));
		//System.out.println("inserting completed of"+ hashtable[x].first);
		//hashtable[x]= ob1;
		return c;
	}

//	@Override
//	public int update(K key, T obj) {
//		// TODO Auto-generated method stub
//		Pair key1= (Pair) key;
//		Student_record ob1= (Student_record) obj;
//		int x;
//		int i=0;
//		String str= key1.first_name.concat(" "); 
//		str=str.concat(key1.last_name);
//		long h1=djb2(str,N);
//		long h2=sdbm(str,N);
//		int c=0;
//		x= (int) ((h1+ h2*i)% N);
//		c=c+1;
//		boolean found= false;
//		System.out.println("Entered update");
//		while(hashtable[x]!=null)
//		{
//			System.out.println("object="+ hashtable[x].first);
//			if(hashtable[x].fname()==key1.first_name && hashtable[x].lname()==key1.last_name)
//			{
//				found=true;
//				break;
//			}
//			else
//			{
//				i=i+1;
//				x= (int) ((h1+ h2*i)% N);
//				c=c+1;
//			}
//		}
//		if (found==true)
//		{
//			hashtable[x]= ob1;
//			return c;
//		}
//		else
//		{
//			System.out.println("E");
//			return (Integer) null;
//		}
//	}
	public int update(K key, T obj)
	{
		String str=key.toString();
		String s1="";
		int j;
		for( j=0;str.charAt(j)!=' ';j++)
		{

		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		int x;
		int i=0;
		long h1=djb2(s1,N);
		long h2=sdbm(s1,N);
		int c=0;
		x= (int) ((h1+ h2*i)% N);
		c=c+1;
		while(hashtable[x].student_key!=null || hashtable[x].first.equals("*"))
		{
			if(hashtable[x].first.equals("*"))
			{
				i=i+1;
				x= (int) ((h1+ h2*i)% N);
				c=c+1;
			}
			else
			{
				
				if((hashtable[x].student_key.toString()).equals(str))
				{
					//System.out.println(x);
					hashtable[x]=new Element(obj, key, obj.toString());
					break;
				}
				else
				{
					//System.out.println(x);
					i=i+1;
					x= (int) ((h1+ h2*i)% N);
					c=c+1;
				}
			}
		}
		return c;
	}
//	@Override
//	public int delete(K key) {
//		Pair key1= (Pair) key;
//		// TODO Auto-generated method stub
//		int x;
//		int i=0;
//		String str= key1.first_name.concat(" "); 
//		str=str.concat(key1.last_name);
//		long h1=djb2(str,N);
//		long h2=sdbm(str,N);
//		int c=0;
//		x= (int) ((h1+ h2*i)% N);
//		c=c+1;
//		boolean found= false;
//		while(hashtable[x]!=null)
//		{
//			if(hashtable[x].fname()==key1.first_name && hashtable[x].lname()==key1.last_name)
//			{
//				found=true;
//				break;
//			}
//			else
//			{
//				i=i+1;
//				x= (int) ((h1+ h2*i)% N);
//				c=c+1;
//			}
//		}
//		if (found==true)
//		{
//			hashtable[x].first="*";
//			return c;
//		}
//		else
//		{
//			System.out.println("E");
//			return (Integer) null;
//		}
//		while(hashtable[x].fname()!=key.first_name||hashtable[x].lname()!= key.last_name)
//		{
//			x= (int) ((h1+ h2*i)% N);
//			c=c+1;
//		}
//	}
	public int delete(K key)
	{
		int x;
		int i=0;
		String str=key.toString();
		String s1="";
		int j;
		for( j=0;str.charAt(j)!=' ';j++)
		{
		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		long h1=djb2(s1,N);
		long h2=sdbm(s1,N);
		int c=0;
		x= (int) ((h1+ h2*i)% N);
		c=c+1;
		while(hashtable[x].student_key!=null || hashtable[x].first.equals("*"))
		{
			if(hashtable[x].first.equals("*"))
			{
				i=i+1;
				x= (int) ((h1+ h2*i)% N);
				c=c+1;
			}
			else
			{
				String s2= hashtable[x].student_key.toString();
				if(s2.equals(str))
				{
					hashtable[x].first="*";
					hashtable[x].student_key=null;
					hashtable[x].student_obj=null;
					break;
				}
				else
				{
					i=i+1;
					x= (int) ((h1+ h2*i)% N);
					c=c+1;
				}
			}
		}
//		System.out.println("hash 2 i="+ i);
		return c;
	}

	@Override
	public boolean contains(K key) {
		String str=key.toString();
		String s1="";
		int j;
		for( j=0;str.charAt(j)!=' ';j++)
		{
		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		// TODO Auto-generated method stub
		int x;
		int i=0;
		long h1=djb2(s1,N);
		long h2=sdbm(s1,N);
		x= (int) ((h1+ h2*i)% N);
		boolean found=false;
		while(hashtable[x]!=null)
		{
			if(hashtable[x].first.equals("*"))
			{
				i=i+1;
				x= (int) ((h1+ h2*i)% N);
			}
			else
			{
				if((hashtable[x].student_key.toString()).equals(str))
				{
					//System.out.println(x);
					found=true;
					break;
				}
				else
				{
					//System.out.println(x);
					i=i+1;
					x= (int) ((h1+ h2*i)% N);
				}
			}
		}
//		if(found==true)
//			System.out.println("T");
//		else
//			System.out.println("F");
		return found;
	}

	@Override
//	public T get(K key) throws NotFoundException {
//		Pair key1= (Pair) key;
//		// TODO Auto-generated method stub
//		int x;
//		int i=0;
//		String str= key1.first_name.concat(" "); 
//		str=str.concat(key1.last_name);
//		long h1=djb2(str,N);
//		long h2=sdbm(str,N);
//		x= (int) ((h1+ h2*i)% N);
//		boolean found=false;
//		while(hashtable[x]!=null)
//		{
//			if(hashtable[x].fname()==key1.first_name && hashtable[x].lname()==key1.last_name)
//			{
//				found=true;
//				break;
//			}
//			else
//			{
//				i=i+1;
//				x= (int) ((h1+ h2*i)% N);
//			}
//		}
//		if(found==true)
//			System.out.print(hashtable[x].fname()+" "+ hashtable[x].lname()+" "+ hashtable[x].hostel()+" "+hashtable[x].department()+" "+ hashtable[x].cgpa());
//		else
//			System.out.println("E");
//		return null;
//	}
	public T get(K key) throws NotFoundException
	{
		String str=key.toString();
		String s1="";
		int j;
		for( j=0;str.charAt(j)!=' ';j++)
		{
		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		int x;
		int i=0;
		long h1=djb2(s1,N);
		long h2=sdbm(s1,N);
		x= (int) ((h1+ h2*i)% N);
		while(hashtable[x]!=null )
		{
			if(hashtable[x].first.equals("*"))
			{
				i=i+1;
				x= (int) ((h1+ h2*i)% N);
			}
			else
			{
				if((hashtable[x].student_key.toString()).equals(str))
				{
					break;
				}
				else
				{
					i=i+1;
					x= (int) ((h1+ h2*i)% N);
				}
			}
		}
		return hashtable[x].student_obj;
	}
//	@Override
//	public String address(K key) throws NotFoundException {
//		String str1;
//		Pair key1= (Pair) key;
//		// TODO Auto-generated method stub
//		int x;
//		int i=0;
//		String str= key1.first_name.concat(" "); 
//		str=str.concat(key1.last_name);
//		long h1=djb2(str,N);
//		long h2=sdbm(str,N);
//		x= (int) ((h1+ h2*i)% N);
//		boolean found=false;
//		while(hashtable[x]!=null)
//		{
//			if(hashtable[x].fname()==key1.first_name && hashtable[x].lname()==key1.last_name)
//			{
//				found=true;
//				break;
//			}
//			else
//			{
//				i=i+1;
//				x= (int) ((h1+ h2*i)% N);
//			}
//		}
//		if (found== true)
//		{
//			str1=Integer.toString(x); 
//			return str1;
//		}
//		else
//		{
//			System.out.println("E");
//			return null;
//		}
//	}
	public String address(K key) throws NotFoundException {
		String str=key.toString();
		String s1="";
		int j;
		for( j=0;str.charAt(j)!=' ';j++)
		{
		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		int x;
		int i=0;
		long h1=djb2(s1,N);
		long h2=sdbm(s1,N);
		x= (int) ((h1+ h2*i)% N);
		while(hashtable[x]!=null )
		{
			if(hashtable[x].first.equals("*"))
			{
				i=i+1;
				x= (int) ((h1+ h2*i)% N);
			}
			else 
			{	
				if((hashtable[x].student_key.toString()).equals(str))
				{
					break;
				}
				else
				{
					i=i+1;
					x= (int) ((h1+ h2*i)% N);
				}
			}
		}
		return Integer.toString(x);
	}
}
