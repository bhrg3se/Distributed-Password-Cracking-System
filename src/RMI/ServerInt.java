/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import Workers.WorkerRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bhargab
 */
public interface ServerInt extends Remote{
    public void completed(String pass) throws RemoteException;
    public void apply(String id) throws RemoteException;
    
}
