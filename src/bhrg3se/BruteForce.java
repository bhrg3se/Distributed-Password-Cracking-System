/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhrg3se;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bhargab
 */
public class BruteForce {
    private  char[] choices = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-.*".toCharArray();
    private static int asciiStart=65;
    private static int asciiEnd=117;
    private static String pass;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter password");
        pass=s.next();
        System.out.println("Enter max size");
        int maxSize=s.nextInt();
        System.out.println("Enter character range in ascii");
        asciiStart=s.nextInt();
        asciiEnd=s.nextInt();
        
        boolean cracked=false;
        ArrayList<Integer> temp=new ArrayList<Integer>();
        temp.add(asciiStart);
        while(!cracked)
        {
            if(check(temp))
            {
                cracked=true;
                System.out.println("!!!!!!!!!Fuck Yeah!!!!!!!!!!");
                
            }
            else increment(temp);
        }
    }
    private static void  increment(ArrayList<Integer> temp)  //remember to use long later just like in GoL
    {
        for(int i=temp.size()-1;i>=0;i--)
        {
            if(!temp.get(i).equals(asciiEnd))
            {
                temp.set(i, temp.get(i)+1);
                break;
            }
            else
            {
                 temp.set(i, asciiStart);
                 if(i==0)
                 {
                     temp.add(0,asciiStart);
                 }
            }
            
        }    
        
    }
    private static boolean check(ArrayList<Integer> temp)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<temp.size();i++)
        {
            sb.append((char)(temp.get(i).intValue()));
        }
        System.out.println(sb);
        if(sb.toString().equals(pass))
            return true;
        else
            return false;
    }
    
}
