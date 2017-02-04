/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Bhargab
 */
public class BruteForce extends Thread{
    
    public BruteForce(long start,long end,byte[] hash,String choices) throws NoSuchAlgorithmException
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
    private byte[] hash;
    private String pass;
    private boolean cracked=false;
    private int len;
    private ArrayList<Integer> arl;
    
    @Override
    public void run()
    {
        cur=new Integer(0);
        
        len=ch.length();
        while(!cracked)
        {
            if(check(cur))
            {
                
                cracked=true;
                
            }
            else
            cur++;
            
        }
        
    }
    
   private boolean check(long temp)
    {
        
        StringBuilder sb=new StringBuilder();
        for(long i=temp;i>=len;sb.append(ch.charAt((int)(i%len))))
        {
            i=i/len;
        }
        
        System.out.println(sb);
        if(md.digest(sb.toString().getBytes()).equals(hash))
        {
            pass=sb.toString();
            return true;
        }    
        else
            return false;
    }
    
    
}
