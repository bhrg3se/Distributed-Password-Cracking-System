/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import RMI.WorkerInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class RemoteWorker extends UnicastRemoteObject implements WorkerInt{
    private BruteForce bf;
    public RemoteWorker() throws RemoteException
    {
        super();
    }

    @Override
    public void assignJob(byte[] hash, int start, int end) {
        try {
            bf=new BruteForce(start, end,hash, "abcdefghijklmnopqrstuvwxyz");
            bf.start();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RemoteWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stop() {
    bf.stop();
    }
    
    
}
