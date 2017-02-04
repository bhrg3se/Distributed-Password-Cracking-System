/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import RMI.ServerInt;
import Server.ServerRMI;
import java.net.MalformedURLException;
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
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Registry reg=LocateRegistry.createRegistry(8080);
    WorkerRMI abc=new WorkerRMI();
    reg.rebind(String.valueOf(abc.hashCode()), abc);
    ServerInt srmi=(ServerInt)Naming.lookup("rmi://localhost:8081/THE_SERVER");
    srmi.apply(String.valueOf(abc.hashCode()));
    
    }
}
