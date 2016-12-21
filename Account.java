/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fatma
 */
public class Account {
    String name;
    double age;
    String gender;
    String password;
    String email;
    game g;
   
    public void add_account_to_account_db()
    {
       //write on file info
        
        Scanner in = new Scanner(System.in);
        System.out.println("sign_up as teacher or student? ");
        String choice= in.nextLine();
        try { 
	      File file = new File("sign_up_form.txt");
              FileWriter fw = new FileWriter(file.getAbsoluteFile());
              BufferedWriter bw = new BufferedWriter(fw);
              bw.write("Name: ");
              bw.newLine();
              bw.write("Age: ");
              bw.newLine();
              bw.write("Gender: ");
              bw.newLine();
              bw.write("Password: ");
              bw.newLine();
              bw.write("Email: ");
              if(choice.equals("teacher"))
              {
                  bw.newLine();
                  bw.write("Certification: ");
              }
              bw.close();
        }
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        System.out.println("please enter your information");
         ArrayList<String> information=new ArrayList<String>();
       try (BufferedReader br = new BufferedReader(new FileReader("sign_up_form.txt")))
        {
           
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                System.out.println(sCurrentLine);
                Scanner read = new Scanner(System.in);
                String info= in.nextLine();  
                information.add(info);
            }
            //sCurrentLine=br.readLine();    
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
       
       try { 
	      
           FileWriter fw = new FileWriter("data_base_account.txt", true);
           BufferedWriter bw = new BufferedWriter(fw);
              bw.write("Name: "+information.get(0));
              bw.newLine();
              bw.write("Age: "+information.get(1));
              bw.newLine();
              bw.write("Gender: "+information.get(2));
              bw.newLine();
              bw.write("Password: "+information.get(3));
              bw.newLine();
            bw.write("Email: "+information.get(4));
              if(choice.equals("teacher"))
              {
                  bw.newLine();
                  teacher_account teacher=new teacher_account();
                  teacher.certification=information.get(5);
                  bw.write("Certification: "+teacher.certification);
              }
              bw.newLine();
             bw.write("----------------------------------------------------");
             bw.newLine();
              
              bw.close();
        }
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
       
    }
    
}
