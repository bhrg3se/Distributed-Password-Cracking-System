/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import RMI.ServerInt;
import Workers.WorkerRMI;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhargab
 */
public class CMain {
    public static UI ui;
    public static int port;
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
         ServerInt srmi=(ServerInt)Naming.lookup("rmi://192.168.1.100:8081/THE_SERVER");
         port=1200+(int)(Math.random()*100);
    System.out.println(port);
           
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CMain.ui=new UI(srmi);
                ui.setVisible(true);
            }
        });
         
    ClientRMI abc=new ClientRMI();
    port=1200+(int)(Math.random()*100);
    System.out.println(port);
    Registry reg=LocateRegistry.createRegistry(port);
    reg.rebind("abc", abc);
    while((ui==null)||(ui.uName==null))
    {        try {
        Thread.sleep(100);
             } catch (InterruptedException ex) {
                 Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
             }
}
    
    }
   
}
