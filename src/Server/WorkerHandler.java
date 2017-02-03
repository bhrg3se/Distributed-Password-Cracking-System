/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class WorkerHandler extends Thread{
    private WorkersRecord wr;
    private LinkedList<Job> jl;
    public WorkerHandler(WorkersRecord wr,LinkedList<Job> jl)
    {
        this.jl=jl;
        this.wr=wr;
    }

    @Override
    public void run() {
        
        try {
            ServerSocket ss=new ServerSocket(1234);
            while(true)
            {
                Socket s=ss.accept();
                wr.workers.add(new Worker(s));
            }
            
            
        
        } catch (IOException ex) {
            Logger.getLogger(WorkerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
