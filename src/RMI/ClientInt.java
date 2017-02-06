/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import Server.Job;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Bhargab
 */
public interface ClientInt extends Remote{
    public void completed(String password) throws RemoteException;
}
