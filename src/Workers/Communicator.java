/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class Communicator extends Thread{
    private String ip;
    private int port;
    private BruteForce bf;
    public Communicator(String ip,int port)
    {
        this.ip=ip;
        this.port=port;
    }

    @Override
    public void run() {
        try {
            Socket s=new Socket(ip,port);
            PrintStream p=new PrintStream(s.getOutputStream());
            Scanner s1=new Scanner(s.getInputStream());
            while(true)
            {
                if(s1.hasNext())
                {
                String in=s1.next();
                if(in=="ASSIGN")
                {
                    String hash=s1.next();
                    int start=s1.nextInt();
                    int end=s1.nextInt();
                    try {
                        bf=new BruteForce(start,end ,hash,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-.*");
                        bf.start();
                        
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(in=="STOP")
                {bf.stop();}
                }
                else
                {
                    if(bf.hasFinished()==1)
                        p.print("CRACKED "+bf.pass );// did that shit
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Communicator.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
}
