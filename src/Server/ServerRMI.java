/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import RMI.ClientInt;
import RMI.ServerInt;
import RMI.WorkerInt;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class ServerRMI extends UnicastRemoteObject implements ServerInt{
   public ServerRMI() throws RemoteException
   {
       super();

   }

    

    @Override
    public void completed(String pass) throws RemoteException {
    
 /*   for(int i=0;i<SMain.wr.workers.size();i++)
    {
        SMain.wr.workers.get(i).stop();
    }
  */
   

     System.out.println("Password is: "+pass);
    
    SMain.crmi.completed(pass);  
        
    }

    @Override
    public void apply(String add,int port)  {
     
       try {
           WorkerInt worker=(WorkerInt)Naming.lookup("rmi://"+add+":"+port+"/"+"abc");
           SMain.wr.workers.add(worker);
           System.out.println("Applied");
       } catch (NotBoundException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (MalformedURLException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (RemoteException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void addJob(String aHash,String ch,int maxL,String add,int port) throws RemoteException {
       
       try {
           
           SMain.crmi=(ClientInt)Naming.lookup("rmi://"+add+":"+port+"/"+"abc");
       } catch (NotBoundException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (MalformedURLException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       }
          Job j=new Job(aHash,ch,maxL,add);
        SMain.jobList.push(j);
        new Scheduler(SMain.wr).start();           
        System.out.println("cllll");
  }
    


}
