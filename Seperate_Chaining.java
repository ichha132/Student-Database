import java.lang.Math;
public class Seperate_Chaining<K,T> implements MyHashTable_<K, T> {
	int N;
	BST<K,T>[] hashtable;
	@SuppressWarnings("unchecked")
	public Seperate_Chaining(int N)
	{
		this.N=N;
		hashtable= new BST[this.N];
	}
	public static long djb2(String str, int hashtableSize) { 
	    long hash = 5381; 
	    for (int i = 0; i < str.length(); i++) { 
	        hash = ((hash << 5) + hash) + str.charAt(i); 
	    } 
	    return Math.abs(hash) % hashtableSize; 
	}
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
		//System.out.println(str);
		String s1="";
		int j;
		for( j=0;j<str.length()&& str.charAt(j)!=' ';j++)
		{
			
		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		//System.out.println(s1);
		int x;
		long h;
		h=djb2(s1,this.N);
		x= (int) h;
		if(hashtable[x]==null)
		hashtable[x]=new BST();
		int count=0;
		count =hashtable[x].insert(key, obj);
		return count;
	}

	@Override
	public int update(K key, T obj) {
		// TODO Auto-generated method stub
		String str=key.toString();
		String s1="";
		int j;
		for( j=0;j<str.length()&&str.charAt(j)!=' ';j++)
		{
			
		}
		for(j=j+1; j<str.length();j++)
		{
			s1=s1+str.charAt(j);
		}
		int x;
		long h;
		h=djb2(s1,this.N);
		x= (int) h;
		int m=hashtable[x].just_update(key, obj);
		return m;
		//Node temp= hashtable[x].search1(hashtable[x].root, key);
	}

	@Override
	public int delete(K key) {
		// TODO Auto-generated method stub
		String str=key.toString();
		String s1="";
		int i;
		for( i=0;i<str.length()&&str.charAt(i)!=' ';i++)
		{
			
		}
		for(i=i+1; i<str.length();i++)
		{
			s1=s1+str.charAt(i);
		}
		int x;
		long h;
		h=djb2(s1,this.N);
		x= (int) h;
		int count=hashtable[x].delete(key);
		return count;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		String str=key.toString();
		String s1="";
		int i;
		for( i=0;i<str.length()&&str.charAt(i)!=' ';i++)
		{
			
		}
		for(i=i+1; i<str.length();i++)
		{
			s1=s1+str.charAt(i);
		}
		int x;
		long h;
		h=djb2(s1,this.N);
		x= (int) h;
		if (hashtable[x]!=null)
		{
			return hashtable[x].search(key);
		}
		else
			return false;
	}
	
	@Override
	public T get(K key) throws NotFoundException {
		// TODO Auto-generated method stub
		String str=key.toString();
		String s1="";
		int i;
		for( i=0;i<str.length()&&str.charAt(i)!=' ';i++)
		{
			
		}
		for(i=i+1; i<str.length();i++)
		{
			s1=s1+str.charAt(i);
		}
		int x;
		long h;
		h=djb2(s1,this.N);
		x= (int) h;
		return hashtable[x].get_update(key);
	}

	@Override
	public String address(K key) throws NotFoundException {
		// TODO Auto-generated method stub
		String str=key.toString();
		String s1="";
		int i;
		for( i=0;i<str.length()&&str.charAt(i)!=' ';i++)
		{
			
		}
		for(i=i+1; i<str.length();i++)
		{
			s1=s1+str.charAt(i);
		}
		String add="";
		int x;
		long h;
		h=djb2(s1,this.N);
		x= (int) h;
		String s2=hashtable[x].search_seq(key);
		add= Integer.toString(x)+"-"+ s2;			//importance 
		return add;
	}

}
