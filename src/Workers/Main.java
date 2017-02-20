/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import RMI.ServerInt;
import Server.ServerRMI;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Enumeration;

/**
 *
 * @author Bhargab
 */
public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, UnknownHostException, IOException {
    String add=getIp();
    System.setProperty("java.rmi.server.hostname",add);
    srmi=(ServerInt)Naming.lookup("rmi://192.168.1.100:8081/THE_SERVER");
    WorkerRMI abc=new WorkerRMI();
    int port=1200+(int)(Math.random()*100);
    System.out.println(port);
    Registry reg=LocateRegistry.createRegistry(port);
    
    reg.rebind("abc", abc);
    
    srmi.apply(add,port);
//   srmi.apply(InetAddress.getLocalHost().getHostAddress(),port);
    System.out.println(add);
   
        
      
    
   
    
    
    }
    
    
    public static  ServerInt srmi;
    
    
    
    public static String getIp() throws SocketException
    {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
    String add = null;
    while(networkInterfaces.hasMoreElements())
    {
        NetworkInterface nextElement = networkInterfaces.nextElement();
        if(!nextElement.isLoopback()||nextElement.isUp())
        {
            Enumeration<InetAddress> adds = nextElement.getInetAddresses();
            add=adds.nextElement().getHostAddress();
            if(add.length()>15);
            add=adds.nextElement().getHostAddress();
            
            break;
        }   
    }
    return add;
    }
}
