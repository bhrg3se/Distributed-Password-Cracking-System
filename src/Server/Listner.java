/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class Listner extends Thread{

    private Worker w;
    public Listner(Worker w)
    {
        this.w=w;
    }
    @Override
    public void run() 
    {
        try {
            //while(true) yo pachi matra rakhne

            Scanner s1=new Scanner(w.getSocket().getInputStream());
            if(s1.next()=="CRACKED")
            System.out.println("Password is:  "+s1.next());
            else
            System.out.println("FUCKKKKKKK!!!!!!  ");
                
        } catch (IOException ex) {
            Logger.getLogger(Listner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
