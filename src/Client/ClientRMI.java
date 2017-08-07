/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import RMI.ClientInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bhargab
 */
public class ClientRMI extends UnicastRemoteObject implements ClientInt{
    private JLabel j;
    public ClientRMI(JLabel j) throws RemoteException
    {
        super();
        this.j=j;
    }

    @Override
    public void completed(String password) {
      JOptionPane.showMessageDialog(null, "Password is:"+password, "Completed", JOptionPane.INFORMATION_MESSAGE);
      j.setText("Completed\nPassword:"+password);
    }
    
}
