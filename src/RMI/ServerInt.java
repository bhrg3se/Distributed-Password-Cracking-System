/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import Server.Job;
import Workers.WorkerRMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bhargab
 */
public interface ServerInt extends Remote{
    public void completed(String pass) throws RemoteException;
    public void apply( int port) throws RemoteException;
    public void addJob(String hash,String algo,String charset,int maxLen,String salt,String saltPos,int port) throws RemoteException;
    public void stop();
}
