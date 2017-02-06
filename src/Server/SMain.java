/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import RMI.ClientInt;
import RMI.ServerInt;
import Workers.WorkerRMI;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class SMain {
    public static WorkersRecord wr;
    public static LinkedList<Job> jobList;
    public static ClientInt crmi;
    public static void main(String[] args) throws RemoteException {
       
   
        //085908f6599e7bd7b4e358a1f06aa61f3569e450=oh
 //       Job j=new Job("c64d3fcde20c5cd03142171e5ac47a87aa3c8ace","abc",3,"bhrg3se");
        wr=new WorkersRecord();
        jobList=new LinkedList<Job>();
        Registry reg=LocateRegistry.createRegistry(8081);
        ServerRMI abc=new ServerRMI();
        reg.rebind("THE_SERVER", abc);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
