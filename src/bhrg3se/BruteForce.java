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
   
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter password");
        String pass=s.next();
        System.out.println("Enter max size");
        int maxSize=s.nextInt();
        ArrayList<Integer> temp=new ArrayList<Integer>();
        for(int i=0;i<maxSize;i++)
        {
            temp.add(0);
        }
    }
    private void increment(ArrayList<Integer> cSet,int maxSize)
    {
        for(int i=cSet.size()-1;i>=0;i--)
        {
            if(!cSet.get(i).equals(64))
            {
                cSet.set(i, cSet.get(i)+1);
                break;
            }
            else
            {
                 cSet.set(i, 0);
                 if(i==0)
                 {
                     cSet.add(0,0);
                 }
            }
            
        }    
        
    }
    
}
