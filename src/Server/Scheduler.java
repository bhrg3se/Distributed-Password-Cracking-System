/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.LinkedList;

/**
 *
 * @author Bhargab
 */
public class Scheduler extends Thread{
    private LinkedList<Job> jq;
    private WorkersRecord wr;
    
    public Scheduler(LinkedList<Job> jq,WorkersRecord wr)
    {
        this.jq=jq;
        this.wr=wr;
    }
    @Override
    public void run() {
                System.out.println("Scheduler Started");
        while(true)
        {
            if(!jq.isEmpty())
            {
                
                 while(wr.workers.isEmpty());// Problem
                         System.out.println("try");
                Job j=jq.pop();
                int part=j.choices.length()/wr.getNum();
                for(int i=0;i<wr.getNum();i++)
                {
                   
                       
                    
                    wr.workers.get(i).send("ASSIGN "+j.hash+" "+(part*i)+" "+(part*(i+1)));
                            System.out.println("Worker "+i+" assigned");
                }
                
            }
            break;//do only one job
        }
    }
    
    
    
}
