/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhrg3se;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
/**
 *
 * @author Bhargab
 */
public class Worker {
    public static void main(String[] args) throws IOException {
        
    //Socket s =new Socket("localhost",80);
    System.out.println(getIp());
    System.out.println("8");
      
}
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
    

