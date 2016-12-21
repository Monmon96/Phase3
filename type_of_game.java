/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Qenawy
 */
public class type_of_game {
    
    public String name;
    public int quantity;
    
    teacher_account obj;
     public type_of_game()
     {
    	 this.name=name;
         this.quantity=quantity;
         this.obj=obj;
     }
     
    public ArrayList<type_of_game>view_type_of_game(){
        ArrayList<type_of_game>list=new ArrayList<type_of_game>();
       type_of_game ob =new type_of_game();
       ob.name="t_f";
       ob.name="mcq";
        list.add(ob);
       
        return list;
    
    }
   
}
