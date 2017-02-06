/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import RMI.ServerInt;
import Server.ServerRMI;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Bhargab
 */
public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, UnknownHostException {
    ServerInt srmi=(ServerInt)Naming.lookup("rmi://localhost:8081/THE_SERVER");
    WorkerRMI abc=new WorkerRMI();
    int port=1200+(int)(Math.random()*100);
    System.out.println(port);
    Registry reg=LocateRegistry.createRegistry(port);
    reg.rebind("abc", abc);
   srmi.apply(InetAddress.getLocalHost().getHostAddress(),port);
    System.out.println(InetAddress.getLocalHost().getHostAddress());
        
      
    
   
    
    
    }
}
