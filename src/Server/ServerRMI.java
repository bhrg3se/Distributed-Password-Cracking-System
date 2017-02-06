/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

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
    System.out.println("Password is: "+pass);
    for(int i=0;i<SMain.wr.getNum();i++)
    {
        SMain.wr.workers.get(i).stop();
    }
    }

    @Override
    public void apply(String id,int port)  {
     
       try {
           WorkerInt worker=(WorkerInt)Naming.lookup("rmi://localhost:"+port+"/"+id);
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
    public void addJob(String aHash,String ch,int maxL,String userName) {
        Job j=new Job(aHash,ch,maxL,userName);
        SMain.jobList.push(j);
        new Scheduler(SMain.wr).start();
        
        System.out.println("cllll");
  }
    


}
