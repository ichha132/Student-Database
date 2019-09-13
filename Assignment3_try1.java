import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Assignment3_try1 {
	static int tablesize;
	static String hashing_type;
	public static void main(String[] args) throws IOException, NotFoundException, FileNotFoundException
	{
		tablesize=Integer.parseInt(args[0]);								//tablesize= Integer.parseInt(args[0]);
		hashing_type=args[1];								//hashing_type=args[1];
		FileReader file1= new FileReader(args[2]);				//FileReader file1= new FileReader(args[2]);
		BufferedReader file= new BufferedReader(file1);
		String line= file.readLine();
		//String details[]= new String[]
//		tablesize=5;
//		hashing_type="SCBST";
//		//FileReader file1= new FileReader("C:\\Users\\Ichha Rathod\\eclipse-workspace\\Assignment3_attempt1\\src\\Ass3.txt");
//		FileReader file1= new FileReader("C:\\Users\\Ichha Rathod\\eclipse-workspace\\Assignment3_attempt1\\src\\input3.txt");				//FileReader file1= new FileReader(args[2]);
//		BufferedReader file= new BufferedReader(file1);
//		String line= file.readLine();
		
		if(hashing_type.equals("DH"))
		{
			Double_Hashing<Pair, Student_record> dh= new Double_Hashing<Pair, Student_record>(tablesize);
			while(line!=null)
			{
				String task="";
				int i=0;								// count on a line of file
				for(i=0; line.charAt(i)!=' ';i++)		//Finding task
				{
					task=task+line.charAt(i);
				}
				i=i+1;									//i !=' '
				//System.out.println("task=" + task);
				if(task.equals("insert"))			//task insert
				{
					Student_record student;
					Pair tuple= null;
					String st_insert[]={"","","","",""};
					//st_insert = {"","","","",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i; i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_insert[j]= st_insert[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					//System.out.println("File line");
					tuple= new Pair(st_insert[0],st_insert[1]);				// T obj, K key are updated.
					student= new Student_record(st_insert[0],st_insert[1],st_insert[2],st_insert[3],st_insert[4]);		
					int y= dh.insert(tuple, student);
					System.out.println(y);
				}
				//insert part done.
				else if(task.equals("update"))
				{
					//to be done
					Student_record student;
					Pair tuple= null;
					String st_update[]= {"","","","",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_update[j]= st_update[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple=new Pair(st_update[0],st_update[1]); 
					student= new Student_record(st_update[0],st_update[1],st_update[2],st_update[3], st_update[4]);
					boolean b= dh.contains(tuple);
					System.out.println(b);
					if(b== true)
					{
						int m= dh.update(tuple,student);
						System.out.println(m);
					}
					else
						System.out.println("E");
				}
				//update done
				else if(task.equals("delete"))
				{
					//to be done
					Pair tuple= null;
					String st_delete[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_delete[j]= st_delete[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_delete[0],st_delete[1]);
					if(dh.contains(tuple)==true)
					{
						int m=dh.delete(tuple);
						System.out.println(m);
					}
					else
						System.out.println("E");
				}
				// delete done
				else if(task.equals("contains"))
				{
					Pair tuple= null;
					String st_contains[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_contains[j]= st_contains[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_contains[0],st_contains[1]);
					if(dh.contains(tuple)== true)
						System.out.println("T");
					else
						System.out.println("F");
				}
				else if (task.equals("get"))
				{
					//to be done
					Pair tuple= null;
					String st_contains[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_contains[j]= st_contains[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_contains[0],st_contains[1]);
//					try
//					{
//						Student_record obj=(Student_record) dh.get(tuple);
//						System.out.println(obj.first+" "+obj.last+" "+ obj.hostel+" "+ obj.department+" "+ obj.cgpa);
//					}
//					catch(NotFoundException e )
//						{System.out.println("E");}
					if(dh.contains(tuple)==true)
					{
						Student_record obj=(Student_record) dh.get(tuple);
						System.out.println(obj.first+" "+obj.last+" "+ obj.hostel+" "+ obj.department+" "+ obj.cgpa);
					}
					else
						System.out.println("E");
						
				}
				else if(task.equals("address"))
				{
					//to be done
					Pair tuple= null;
					String st_contains[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_contains[j]= st_contains[j] + line.charAt(i);
							//System.out.print(st_contains[j]+" ");
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_contains[0],st_contains[1]);
//					try
//					{
//						String m=dh.address(tuple);
//						System.out.println(m);
//					}
//					catch(NotFoundException e )
//					{System.out.println("E");}
					if(dh.contains(tuple))
					{
						String m=dh.address(tuple);
						System.out.println(m);
					}
					else
						System.out.println("E");
				}
				line=file.readLine();
			}
		}
		else if(hashing_type=="SCBST")
		{
			Seperate_Chaining<Pair, Student_record> dh= new Seperate_Chaining<Pair, Student_record>(tablesize);
			while(line!=null)
			{
				String task="";
				int i=0;								// count on a line of file
				for(i=0; line.charAt(i)!=' ';i++)		//Finding task
				{
					task=task+line.charAt(i);
				}
				i=i+1;									//i !=' '
				//System.out.println("task=" + task);
				if(task.equals("insert"))			//task insert
				{
					Student_record student;
					Pair tuple= null;
					String st_insert[]={"","","","",""};
					//st_insert = {"","","","",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_insert[j]= st_insert[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_insert[0],st_insert[1]);				// T obj, K key are updated.
					student= new Student_record(st_insert[0],st_insert[1],st_insert[2],st_insert[3],st_insert[4]);		
					int y= dh.insert(tuple, student);
					System.out.println(y);
				}
				else if(task.equals("delete"))
				{
					//to be done
					Pair tuple= null;
					String st_delete[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_delete[j]= st_delete[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_delete[0],st_delete[1]);
					if(dh.contains(tuple)==true)
					{
						int m=dh.delete(tuple);
						System.out.println(m);
					}
					else
						System.out.println("E");
				}
				else if(task.equals("contains"))
				{
					Pair tuple= null;
					String st_contains[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_contains[j]= st_contains[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_contains[0],st_contains[1]);
					if(dh.contains(tuple)== true)
						System.out.println("T");
					else
						System.out.println("F");
				}
				else if(task.equals("update"))
				{
					Student_record student;
					Pair tuple= null;
					String st_update[]= {"","","","",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_update[j]= st_update[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple=new Pair(st_update[0],st_update[1]); 
					student= new Student_record(st_update[0],st_update[1],st_update[2],st_update[3], st_update[4]);
					boolean b= dh.contains(tuple);
					if(b==true)
						System.out.println(dh.update(tuple, student));
					else
						System.out.println("E");
				}
				else if(task.equals("get"))
				{
					//to be done
					Pair tuple= null;
					String st_contains[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_contains[j]= st_contains[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_contains[0],st_contains[1]);
//					try
//					{
//						Student_record obj=(Student_record) dh.get(tuple);
//						System.out.println(obj.first+" "+obj.last+" "+ obj.hostel+" "+ obj.department+" "+ obj.cgpa);
//					}
//					catch(NotFoundException e )
//						{System.out.println("E");}
					if(dh.contains(tuple)==true)
					{
						Student_record obj=(Student_record) dh.get(tuple);
						System.out.println(obj.first+" "+obj.last+" "+ obj.hostel+" "+ obj.department+" "+ obj.cgpa);
					}
					else
						System.out.println("E");
				}
				else if (task.equals("address"))
				{
					Pair tuple= null;
					String st_contains[]= {"",""};
					int j=0;							//count on elements of array
					while(i<line.length())				//Updating st_insert according to a line of the file
					{
						for(i=i;  i<line.length()&& line.charAt(i)!=' ';i++)
						{
							st_contains[j]= st_contains[j] + line.charAt(i);
						}
						i=i+1;
						j=j+1;
					}
					tuple= new Pair(st_contains[0],st_contains[1]);
					if(dh.contains(tuple)==true)
					{
						String address=dh.address(tuple);
						System.out.println(address);
					}
					else
						System.out.println("E");
				}
				line=file.readLine();
		}
	}
		else
			System.out.println("Invalid hashing type");
}
}

