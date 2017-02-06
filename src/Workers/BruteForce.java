/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import RMI.ServerInt;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Bhargab
 */
public class BruteForce extends Thread{
    
    public BruteForce(long start,long end,String hash,String choices) throws NoSuchAlgorithmException
    {
        this.md = MessageDigest.getInstance("SHA-1");
        
        this.start=start;
        this.end=end;
        this.hash=hash; //??????????????????????????????????????????????????????????????????????????????????
        this.ch=choices;
        System.out.println(hash+choices);
        arl=new ArrayList<>();
    }
    private int maxLen;
    private  String ch ;
    //= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-.*";
    private MessageDigest md;
    private long cur;
    private long start;
    private long end;
    private String hash;
    private String pass;
    private boolean cracked=false;
    private int len;
    private ArrayList<Integer> arl;
    
    @Override
    public void run()
    {
        cur=start;
        
        len=ch.length();
        while(!cracked&&cur<=end)
        {
            if(check(cur))
            {
                
                cracked=true;
                try {
                    ServerInt srmi=(ServerInt)Naming.lookup("rmi://localhost:8081/THE_SERVER");
                    srmi.completed(pass);
                } catch (NotBoundException ex) {
                    Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(BruteForce.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else
            cur++;
            
        }
        
    }
    
   private boolean check(long temp)
    {
        
        StringBuilder sb=new StringBuilder();
        long i=temp;
        do
        {
            sb.append(ch.charAt((int)(i%len)));
            i=i/len;
        //    System.out.println(sb.length());
            
            
        }while(i>=len);
        System.out.println(sb.toString());
        /*System.out.println(md.digest(sb.toString().getBytes()));
        System.out.println("=");
        System.out.println(sb.length());
        System.out.println(hash);
        System.out.println("      h");
         */
       // .equals(hash)
        
        if(byteArray2Hex(DigestUtils.sha(sb.toString())).equals(hash))
        {
            System.out.println(sb);
            pass=sb.toString();
            return true;
        }    
        else
            return false;
    }
    private static String byteArray2Hex(final byte[] hash) {
    Formatter formatter = new Formatter();
    for (byte b : hash) {
        formatter.format("%02x", b);
    }
    return formatter.toString();
}
    
}
