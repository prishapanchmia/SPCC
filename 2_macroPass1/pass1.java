import java.util.*;
import java.lang.*;
import java.io.*;

class pass1
{
	public static void main(String []args)
	{
		BufferedReader reader;
		int lc=0,mnti=0,mdti=0,i,j,li=0,alai=0,alac=0,alasi=0,prgi=0;
		String[] mdt = new String[200];
		String[] mnt = new String[100];
		String[] ala = new String[100];		
		int[] mntin = new int[100];
		int[] alain = new int[100];
		int[][] alas = new int[100][3];
		String[] prgstat = new String[200];
		try 
		{
			reader = new BufferedReader(new FileReader("prg.txt"));
			String line = reader.readLine();
			String[] words = line.split("\\s+");						
			//System.out.println(sym[0]+" "+symtab[0][0]);	
			while (!line.trim().equals("END")) 
			{
				if(words[0].equals("MACRO"))
				{
					li=0;alac=0;
					//System.out.println("yes");
					while(!words[0].equals("MEND"))
					{
						line = reader.readLine();
						words = line.split("\\s+");	
						if(li==0)
						{
							mnt[mnti] = words[0];
							String[] op = words[1].split(",");
							alas[alasi][0] = alai; alas[alasi][1] = mnti;alas[alasi][2]=op.length;
							for(i=0;i<op.length;i++)
							{
								ala[alai] = op[i];
								alain[alai] = alac;
								alac++;
								alai++;
							} 
							mntin[mnti] = mdti;							
							mdt[mdti] = line;
							mnti++;
							mdti++;
							alasi++;
							li++;
						}
						else
						{
							for(i=alas[alasi-1][0];i<alai;i++)
							{
								if(line.contains(ala[i])==true) line = line.replace(ala[i],"#"+Integer.toString(alain[i]));
							}
							mdt[mdti] = line;
							mdti++;
						}
					}
					//System.out.println(line);
				}
				else 
				{
					prgstat[prgi] = line;
					prgi++;
				}
				line = reader.readLine();	
				words = line.split("\\s+");								
			}
			reader.close();	
			prgstat[prgi] = line;
			prgi++;
            System.out.println("\nMNT is: \n");
			for(i=0;i<mnti;i++) System.out.println(mnt[i]+" "+mntin[i]);
            System.out.println("\nMDT is: \n");
			for(i=0;i<mdti;i++) System.out.println(i+" "+mdt[i]);	
            System.out.println("\nALA is: \n");
			for(i=0;i<alai;i++) System.out.println(alain[i]+" "+ala[i]);
        }
        catch (IOException e) { e.printStackTrace(); }
    }
    }