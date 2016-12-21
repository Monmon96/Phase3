/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;

import java.io.IOException;

/**
 *
 * @author Qenawy
 */
public class run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        type_of_game a=new  type_of_game();
        game b=new game();
        //b.StartPlay("rucky","1");
        //b.viewgame();
        b.StartPlay("rucky","1");
        //b.create_game();
    }
    
}
