import java.io.*;
import java.util.*;

public class lexical
{
	public static boolean findnum(String x)
	{
		boolean numeric ;
		numeric = x.matches("-?\\d+(\\.\\d+)?");
		if(numeric)
		return true;
		else
		return false;
	}
	public static boolean findop(String x) 
	{
		String operators[] ={"+","-","/","*","="};
		for(int i = 0; i<operators.length; i++)
		{
			if(operators[i].equals(x))
			return true;
		}
		return false;
	}
	public static boolean findkey(String x) 
	{
		String keys[] = {"main","int","double","float","char","String","long","boolean","byte","short","void"};
		for(int i = 0; i<keys.length; i++)
		{
			if(keys[i].equals(x))
			return true;
		}
		return false;
	}
	public static boolean findsep(String x) 
	{
		String sep[] ={"(",")",",","[","]","{","}",";"};
		for(int i = 0; i<sep.length; i++)
		{
			if(sep[i].equals(x))
			return true;
		}
		return false;
	}
	public static boolean check(String x)
	{
		boolean temp ;
		temp = x.matches("^[a-zA-Z]{1}");
		if(temp)
		return true;
		else
		return false;
	}
	public static void main(String args[])throws IOException
	{
		File f= new File("input.txt");
		Scanner sc= new Scanner(f);
		while(sc.hasNext())
		{
			String b=sc.next();
			String[] sp = b.split(" "); 
			for(int i=0; i<sp.length; i++)
			{
				if(findop(sp[i])==true)
				System.out.println(sp[i]+" is an operator.");
				else if(findkey(sp[i])==true)
				System.out.println(sp[i]+" is a keyword.");
				else if(findsep(sp[i])==true)
				System.out.println(sp[i]+" is a seperator.");
				else if(findnum(sp[i])==true)
				System.out.println(sp[i]+" is a constant.");
				else if (check(sp[i])==true)
				System.out.println(sp[i]+" is a variable.");
				else
				System.out.println(sp[i]+" is not a Valid identifier!");
			}
		}
	}
}