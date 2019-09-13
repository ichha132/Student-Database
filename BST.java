
public class BST<K,T> {
	Node<K,T> root;
	int ci;
	int cd1;
	int cd2;
	int cu;
	int cu_support;
	boolean found_search;
	String seq="";
	T temp_obj;
	int temp_add;
	public BST()
	{
		root= null;
	}
//	public int insert(K key, T obj) {
//		// TODO Auto-generated method stub
//		this.ci=0;
//		//Node root1=root;
//		root=insert(root ,key,obj);
//		//root=root1;
//		return (this.ci);
//	}
	public int insert(K key, T obj) {
		// TODO Auto-generated method stub
		this.ci=0;
		if(root==null)
		{
			root=insert(root,key,obj);
		}
		else
		{
			Node r=root;
			root=insert(root ,key,obj);
			root=r;
		}
		return (this.ci);
	}
	@SuppressWarnings("unchecked")
	public Node insert(Node r, K key, T obj)
	{
		
		if(r==null)
		{
			r= new Node(null, null, key, obj);
			ci=ci+1;
		}
		else
		{
			String str2= r.obj.toString();
			String str1=obj.toString();
			int t;
			String s1="";
			String s2="";
			if(str1.equals(str2))
			{
				str1=key.toString();
				str2=r.key.toString();
				for(t=0;t<str1.length()&&str1.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str1.length();t++)
				{
					s1=s1+str1.charAt(t);
				}
				for(t=0;t<str2.length()&&str2.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str2.length();t++)
				{
					s2=s2+str2.charAt(t);
				}
				
				if(s1.compareTo(s2)<=0)
				{
					ci=ci+1;
					r.left= insert(r.left,key,obj);
				}
				else
				{
					ci=ci+1;
					r.right=insert(r.right,key,obj);
				}
			}
			else
			{
				if(str1.compareTo(str2)<=0)
				{
					ci=ci+1;
					r.left= insert(r.left,key,obj);
				}
				else
				{
					ci=ci+1;
					r.right=insert(r.right,key,obj);
				}
			}
		}
		return r;
	}
	public int just_update(K key,T obj)
	{
		found_search=false;
		cu=0;
		Node root1;
		root1=search1(root,key);
		root1.obj=obj;
		return cu;
	}
//	public int just_update(K key,T obj)
//	{
//		this.cu=0;
//		if(root==null)
//		{
//			//Node root1=root;
//			System.out.println(root.obj.toString());
//			root= update(root, key);
//			root.obj=obj;
//		}
//		else
//		{
//			Node root1=root;
//			root1= update(root,key);
//			root1.obj=obj;
//		}
//		
//		//root=root1;
//		return cu;
//	}
	
	public T get_update(K key)
	{
		root=update(root,key);
		return (T) root.obj;
	}
	public Node update(Node r,K key)
	{
		boolean found=false;
		String s1=key.toString();
		String fname="";
		int i=0;
		for(i=0; s1.charAt(i)!=' '; i++)			//updated
		{
			fname=fname+s1.charAt(i);
		}
		if(r==null)
		{
			return r;
		}
		while(r!=null && found == false)
		{
			String str2= r.obj.toString();
			String str1=fname;
			int t;
			 s1="";
			String s2="";
			if(str1.equals(str2))
			{
				str1=key.toString();
				str2=r.key.toString();
				for(t=0;t<str1.length() && str1.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str1.length();t++)
				{
					s1=s1+str1.charAt(t);
				}
				for(t=0;t<str2.length()&&str2.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str2.length();t++)
				{
					s2=s2+str2.charAt(t);
				}
				
				if(s2.compareTo(s1)>0)
				{
					r=r.left;
				}
				else if (s2.compareTo(s1)<0)
				{
					r=r.right;
				}
				else
				{
					found=true;
					//cu=cu+1;
					break;
				}
				
			}
			else
			{
			
				if(str2.compareTo(str1)>0)
				{
					r=r.left;
				}
				else if (str2.compareTo(str1)<0)
				{
					r=r.right;
				}
				else
				{
					found=true;
					//cu=cu+1;
					break;
				}
			}
			r=update(r,key);
		}
		return r;
	}
	public int delete(K key) {
		// TODO Auto-generated method stub
		//Node r=root;
		this.cd1=0;
		root=delete(root,key);
		return (this.cd1+this.cd2);
	}
	public Node delete(Node r,K key)
	{
		Node temp1,temp2,temp3,temp4;
		int t;
		String s1=key.toString();
		String fname="";
		int i=0;
		for(i=0; s1.charAt(i)!=' '; i++)			//updated
		{
			fname=fname+s1.charAt(i);
		}
		String str1=fname;
		String str2=r.obj.toString();
		if(str1.equals(str2))
		{
			String s2="";
			s1="";
			str1=key.toString();
			str2=r.key.toString();
			for(t=0;t<str1.length() && str1.charAt(t)!=' ';t++)
			{
				
			}
			for(t=t+1;t<str1.length();t++)
			{
				s1=s1+str1.charAt(t);
			}
			for(t=0;t<str2.length()&&str2.charAt(t)!=' ';t++)
			{
				
			}
			for(t=t+1;t<str2.length();t++)
			{
				s2=s2+str2.charAt(t);
			}
			str1=s1;
			str2=s2;
		}
		if(str1.compareTo(str2)==0)
		{
			cd1=cd1+1;
			Node lt,rt;
			lt=r.left;
			rt=r.right;
			if(lt==null && rt==null)
				return null;
			else if(lt==null)
			{
				temp1=rt;
				cd2=cd2+1;
				return temp1;
			}
			else if(rt==null)
			{
				temp1=lt;
				cd2=cd2+1;
				return temp1;
			}
			else
			{
				temp1=rt;
				temp2=rt;
				cd2=cd2+1;
				while(temp1.left!=null)
				{
					temp1=temp1.left;
					cd2=cd2+1;
				}
				temp4=temp1;
				temp4.left=lt;
				temp4.right=rt;
				temp1=null;
				return temp4;
//				temp1.left=lt;
//				return temp2;
			}
		}
		else if(str1.compareTo(str2)<0)
		{
			cd1=cd1+1;
			temp3=delete(r.left,key);
			r.left=temp3;
		}
		else
		{
			cd1=cd1+1;
			r.right=delete(r.right,key);
		}
		return r;
	}
//	public Node delete(Node r,K key)
//	{
//		Node temp1,temp2,temp3;
//		String s1=key.toString(); 	
//		String fname="";
//		int i=0;
//		do								
//		{
//			fname=fname+s1.charAt(i);
//			i=i+1;
//		}
//		while(i<s1.length() && (s1.charAt(i)<65 || s1.charAt(i)>90));			//Put range of ascii values//ascii thingy add it
//		if(fname.compareTo(r.obj.toString())==0)
//		{
//			cd1=cd1+1;
//			Node lt,rt;
//			lt=r.left;
//			rt=r.right;
//			if(lt==null && rt==null)
//				return null;
//			else if(lt==null)
//			{
//				temp1=rt;
//				cd2=cd2+1;
//				return temp1;
//			}
//			else if(rt==null)
//			{
//				temp1=lt;
//				cd2=cd2+1;
//				return temp1;
//			}
//			else
//			{
//				temp1=rt;
//				temp2=rt;
//				cd2=cd2+1;
//				while(temp1.left!=null)
//				{
//					temp1=temp1.left;
//					cd2=cd2+1;
//				}
//				temp1.left=lt;
//				return temp2;
//			}
//		}
//		else if(fname.compareTo(r.obj.toString())<0)
//		{
//			cd1=cd1+1;
//			temp3=delete(r.left,key);
//			r.left=temp3;
//		}
//		else
//		{
//			cd1=cd1+1;
//			r.right=delete(r.right,key);
//		}
//		return r;
//	}
	public boolean search(K key) {
		// TODO Auto-generated method stub
		found_search=false;
		Node root1;
		root1=search1(root,key);
		//boolean b=search1(root,key);
		return found_search;
	}
	public Node search1(Node r, K key)
	{
		String s1=key.toString();
		int t;
		String fname="";
		int i=0;
		for(i=0; s1.charAt(i)!=' '; i++)			//updated
		{
			fname=fname+s1.charAt(i);
		}
		
		while((r!=null) && found_search == false)
		{
			String str1=fname;
			String str2=r.obj.toString();
			if(str1.equals(str2))
			{
				String s2="";
				s1="";
				str1=key.toString();
				str2=r.key.toString();
				
				for(t=0;t<str1.length() && str1.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str1.length();t++)
				{
					s1=s1+str1.charAt(t);
				}
				for(t=0;t<str2.length()&&str2.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str2.length();t++)
				{
					s2=s2+str2.charAt(t);
				}
				str1=s1;
				str2=s2;
			}
			
			if(str2.compareTo(str1)>0)
			{
				cu=cu+1;
				r=r.left;
			}
			else if (str2.compareTo(str1)<0)
			{
				cu=cu+1;
				r=r.right;
			}
			else
			{
				cu=cu+1;
				found_search=true;
				break;
			}
			return search1(r,key);
		}
		return r;
	}
	
	public String search_seq(K key)
	{
		seq="";
		Node r= root;
		r=search_sequence(r,key);
		return this.seq;
	}
	public Node search_sequence(Node r,K key)
	{
		boolean found=false;
		String s1=key.toString();
		int t;
		String fname="";
		int i=0;
		for(i=0; s1.charAt(i)!=' '; i++)			//updated
		{
			fname=fname+s1.charAt(i);
		}
		
		while(r!=null && found == false)
		{
			String str1=fname;
			String str2=r.obj.toString();
			if(str1.equals(str2))
			{
				String s2="";
				s1="";
				str1=key.toString();
				str2=r.key.toString();
				for(t=0;t<str1.length() && str1.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str1.length();t++)
				{
					s1=s1+str1.charAt(t);
				}
				for(t=0;t<str2.length()&&str2.charAt(t)!=' ';t++)
				{
					
				}
				for(t=t+1;t<str2.length();t++)
				{
					s2=s2+str2.charAt(t);
				}
				str1=s1;
				str2=s2;
			}
			
			if(str2.compareTo(str1)>0)
			{
				seq=seq+"L";
				r=r.left;
				r=search_sequence(r,key);
			}
			else if (str2.compareTo(str1)<0)
			{
				seq=seq+"R";
				r=r.right;
				r=search_sequence(r,key);
				
			}
			else
			{
				found=true;
				break;
			}
		}
		return r;
	}
	
}
