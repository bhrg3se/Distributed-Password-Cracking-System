/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Bhargab
 */
public class Worker {
    private String ip;
    private Socket socket;
    private InputStream iS;
    private PrintStream pS;
    public Worker(Socket s) throws IOException
    {
        this.socket=s;
        this.pS=new PrintStream(socket.getOutputStream());
        this.iS=socket.getInputStream();
        new Listner(this);
    }
    public void send(String s)
    {
        pS.print(s);
        
    }
    public Socket getSocket()
    {return socket;}
    
    
}
