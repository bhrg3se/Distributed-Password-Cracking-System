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

    @Override
    public void run() {
        while(true)
        {
            if(!jq.isEmpty())
            {
                Job j=jq.pop();
                int part=j.choices.length()/wr.getNum();
                for(int i=0;i<wr.getNum();i++)
                {
                    wr.workers.get(i).send("ASSIGN "+j.hash+" "+(part*i)+" "+part);
                }
                
            }
            break;//do only one job
        }
    }
    
    
    
}
