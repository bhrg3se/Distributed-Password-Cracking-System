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
    private  Job j;
    private WorkersRecord wr;
    
    public Scheduler(WorkersRecord wrc)
    {
        
        wr=wrc;
        this.j=SMain.jobList.pop();
    }
    @Override
    public void run() {
        
                while(wr.workers.isEmpty()){
                    try {
                    Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                System.out.println(j.choices+j.hash.toString());
                long part=(long) (Math.pow(j.choices.length(),j.maxLen)/wr.workers.size());
                for(int i=0;i<wr.workers.size();i++)
                {
                    try {
                        wr.workers.get(i).assignJob(j.hash,part*i,part*(i+1),j.choices,j.algo,j.salt,j.saltPos);
                    } catch (RemoteException ex) {
                        Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
        
    }
    
    
    
}
