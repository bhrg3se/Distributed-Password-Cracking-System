/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class Scheduler extends Thread{
    private final Job j;
    private WorkersRecord wr;
    
    public Scheduler(Job jo,WorkersRecord wrc)
    {
        this.j=jo;
        wr=wrc;
    }
    @Override
    public void run() {
        
                while(wr.workers.isEmpty()){try {
                    Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                    }
}
                int part=(j.choices.length())/wr.getNum();
                for(int i=0;i<wr.getNum();i++)
                {
                    try {
                        wr.workers.get(i).assignJob(j.hash,part*i,part*(i+1),j.choices);
                    } catch (RemoteException ex) {
                        Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
        
    }
    
    
    
}
