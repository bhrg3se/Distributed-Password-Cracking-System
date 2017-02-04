/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Bhargab
 */
public class Main {
    public static void main(String[] args) throws RemoteException {
        Registry reg=LocateRegistry.createRegistry(8080);
    RemoteWorker abc=new RemoteWorker();
    reg.rebind("worker", abc);
    }
}
