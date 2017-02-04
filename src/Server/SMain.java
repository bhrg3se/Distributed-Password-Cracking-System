/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Workers.WorkerRMI;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Bhargab
 */
public class SMain {
    public static void main(String[] args) throws RemoteException {
       
   
        //085908f6599e7bd7b4e358a1f06aa61f3569e450=oh
        Job j=new Job("oh".getBytes(),"abcoh",3,"bhrg3se");
        WorkersRecord wr=new WorkersRecord();
        Registry reg=LocateRegistry.createRegistry(8081);
        ServerRMI abc=new ServerRMI(wr);
        reg.rebind("THE_SERVER", abc);
        new Scheduler(j,wr).start();
        
    }
    
}
