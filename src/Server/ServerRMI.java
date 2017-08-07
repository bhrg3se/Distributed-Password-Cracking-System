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
import java.rmi.server.ServerNotActiveException;
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
    
    for(int i=0;i<SMain.wr.workers.size();i++)
    {
        SMain.wr.workers.get(i).stop();
    }
  
   

     System.out.println("Password is: "+pass);
    
    SMain.crmi.completed(pass);  
        
    }

    @Override
    public void apply(int port)  {
     
       try {
           String add=getClientHost();
           WorkerInt worker=(WorkerInt)Naming.lookup("rmi://"+add+":"+port+"/"+"abc");
           SMain.wr.workers.add(worker);
           System.out.println("Applied");
       } catch (NotBoundException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (MalformedURLException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (RemoteException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ServerNotActiveException ex) {
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void addJob(String hash,String algo,String charset,int maxLen,String salt,String saltPos,int port) throws RemoteException {
       
       try {
           String add=getClientHost();
           SMain.crmi=(ClientInt)Naming.lookup("rmi://"+add+":"+port+"/"+"abc");
           Job j=new Job(hash,algo, charset, maxLen,salt, saltPos);
           SMain.jobList.push(j);
        new Scheduler(SMain.wr).start();           
        System.out.println("cllll");
       } catch (NotBoundException | MalformedURLException | ServerNotActiveException ex) {   
           Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
       }   
        
  }

    @Override
    public void stop() {
        for(int i=0;i<SMain.wr.workers.size();i++)
    {
            try {
                SMain.wr.workers.get(i).stop();
            } catch (RemoteException ex) {
                Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
  
       
    }
    


}
