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
    
    public BruteForce(int start,int end,String hash,String choices) throws NoSuchAlgorithmException
    {
        this.md = MessageDigest.getInstance("SHA-1");
        this.start=start;
        this.end=end;
        this.hash=hash;
        this.ch=choices;
                System.out.println("BruteForce created");
    }
    
    private  String ch ;
    //= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-.*";
    private MessageDigest md;
    private ArrayList<Integer> cur;
    private int start;
    private int end;
    private String hash;
    public String pass; //dont do this shit
    private boolean cracked;
    private int len;
    private boolean completed;
    
    
    @Override
    public void run()
    {
                System.out.println("Bruteforce started");
        cracked=false;
        completed=false;
        cur=new ArrayList();
        cur.add(0);
        len=1;
        while(!cracked)
        {
            if(check(cur))
            {
                pass=cur.toString();
                cracked=true;
                
            }
            else
            increment(cur);
            
        }
        
    }
    private void  increment(ArrayList<Integer> temp)  //remember to use long later just like in GoL
    {
        for(int i=temp.size()-1;i>=0;i--)
        {
            if(!temp.get(i).equals(end))
            {
                temp.set(i, temp.get(i)+1);
                break;
            }
            else
            {
                 temp.set(i, start);
                 if(i==0)
                 {
                     temp.add(0,start);
                 }
            }
            
        }    
        
    }
   private boolean check(ArrayList<Integer> temp)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<temp.size();i++)
        {
            sb.append((char)(ch.charAt(temp.get(i))));
        }
        System.out.println(sb);
        if(sb.toString().equals(hash))
            return true;
        else
            return false;
    }
    public int hasFinished()
    {
        if(cracked==true)
            return 1;
        if(completed=true)
            return 2;
        else return 0;
    }
    
}
