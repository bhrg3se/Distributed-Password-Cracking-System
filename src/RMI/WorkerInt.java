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
    public void assignJob(String hash, long start, long end,String ch,String algo,String salt,String saltPos) throws RemoteException;
    public void stop() throws RemoteException;
    
}
