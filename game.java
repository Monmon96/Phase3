/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Qenawy
 */
public class game {
	
    public String name;
    String level;
    teacher_account teacher;
    public game(){}
    
    public void StartPlay(String name_game,String level) throws IOException
    {   String path="";
    ArrayList<String> answers=new ArrayList<String>();
    ArrayList<String> user_answers=new ArrayList<String>();
    path=name_game+level+".txt";
   // File f=new File(path);
    // BufferedReader br = null;
      int linecount=0;
      //System.out.println("at file"+path);
    {
           try { 
           BufferedReader br = new BufferedReader(new FileReader(path));
           
	 //br = new BufferedReader(new FileReader(path));
	String line="";
               
        line=br.readLine();
       int i=1;
       System.out.println("put true or false");
       while(line !=null)
         {
             
            ++linecount;
            System.out.println("question" +(i)+"  "+"is "+line.substring(0,line.length()-4));
            answers.add(String.valueOf(line.charAt(line.length()-1)));
            line=br.readLine();
         ++i;
         }
       
         
             }
        
           catch (IOException e) {
 
           }
Scanner reader = new Scanner(System.in);
int x=1;
int d=0;
        while(d<linecount)
         {
             System.out.println(" enter answer of queston" +" "+(x));
               String answer=reader.next();
            ++x;
           user_answers.add(answer);
           ++d;
    }
     try { 
	      
           FileWriter fw = new FileWriter("Answer.txt");
           BufferedWriter bw = new BufferedWriter(fw);
           for(int i=0;i<answers.size();i++)
           {
               if(answers.get(i).equals(user_answers.get(i)))
               {
                   bw.write("t");
                   bw.newLine();
               
               }
               else
               {
                   bw.write("f");
                   bw.newLine();
               }
            }
              bw.close();
        }
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }   
        
    }
        calcScore("Answer.txt");
    }
//public ArrayList<game> LevelsSelectGame(game name)
//    {game ob=new game();
//    if(ob.name=="rocky"){}
//    }
    public  void add_game_to_db(game g)
    {
        try { 
	      
           FileWriter fw = new FileWriter("db_game.txt", true);
           BufferedWriter bw = new BufferedWriter(fw);
           bw.newLine();
           String line=g.name+"-----"+g.level+"-----";
           bw.write(line);
              bw.close();
        }
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public void create_game()
    {
        game ga=new game();
        Scanner in = new Scanner(System.in);
    //    System.out.println("pls enter your name: ");
  //      String name_t= in.nextLine();
        System.out.println("pls enter game_name: ");
        ga.name= in.nextLine();
        System.out.println("pls enter num of levels: ");
        ga.level= in.nextLine();
        System.out.println("pls enter num of questions: ");
        String num= in.nextLine();
        int num_question=Integer.parseInt(num);
        //System.out.println("num "+(level));
        for(int j=1;j<=Integer.parseInt(ga.level);j++)
        {
        String path=ga.name+String.valueOf(j)+".txt";
        try { 
	      
           FileWriter fw = new FileWriter(path);
           BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0;i<num_question;i++)
        {
            System.out.println("pls enter the question: ");
            String question= in.nextLine();
            bw.write(question);
            bw.write("-->");
            System.out.println("pls enter the  model answer of this question: ");
            String ans= in.nextLine();
            bw.write(ans);
            bw.newLine();
             
        }   
              bw.close();
        }
        
      
        
             catch (IOException e) 
        {
            e.printStackTrace(); 
            
        }
    }
//        ga.teacher.name=name_t;
    add_game_to_db(ga);
    
    }

    
    public void viewgame()
    {
   ArrayList<game> game_list=new ArrayList<game>();
    try (
            BufferedReader br = new BufferedReader(new FileReader("db_game.txt")))
        {
           
            String sCurrentLine="";
            sCurrentLine = br.readLine();
            while ((sCurrentLine = br.readLine()) != null) 
            {
                game ga=new game();
                StringTokenizer st=new  StringTokenizer(sCurrentLine,"-----");
                ga.name=st.nextToken();
               ga.level=st.nextToken();
               game_list.add(ga);           
            }
            System.out.println("games name are -------------level");
            for(int i=0;i<game_list.size();i++)
            {
                System.out.println(game_list.get(i).name+"-------------"+game_list.get(i).level);
            }
            //sCurrentLine=br.readLine();    
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
   
}

    public static Double calcScore(String path)
{
	//RandomAccessFile fileToRead = null;
	int cT=0,cF=0;
        ArrayList<String> user_answer=new ArrayList<String>();
         try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
           
            String sCurrentLine="";
            while ((sCurrentLine = br.readLine()) != null) 
            {
                user_answer.add(sCurrentLine);
            }
            //sCurrentLine=br.readLine();    
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
         
		for(int i =0 ;i<user_answer.size();i++)
		{
			if(user_answer.get(i).equals("T")||user_answer.get(i).equals("t"))
			{
				++cT;
			}
			else if (user_answer.get(i).equals("F")||user_answer.get(i).equals("f"))
			{
				++cF;
			}
		}
		
		
			System.out.println("Your right score is : "+ cT+" out of "+user_answer.size());
			
		
	
    
	return (double)cT;
	
}

//public void SelectLevelGame(String name)
//{if(name=="nemo")
//{game n=new
//for(int i=0;i<n.level.size();i++)
//{
//    n.level.add(String.valueOf(i));
//}
//for(int i=0;i<n.level.size();i++){
//    System.out.println("levels of game nemo is"+n.level.get(i));
//}
//}


}
