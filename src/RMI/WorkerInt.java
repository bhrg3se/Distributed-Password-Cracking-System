/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bhargab
 */
public interface WorkerInt extends Remote{
    public void assignJob(byte[] hash,long start,long end,String ch) throws RemoteException;
    public void stop() throws RemoteException;
    
}
