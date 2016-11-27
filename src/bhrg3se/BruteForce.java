/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhrg3se;

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
        StringBuilder temp=new StringBuilder();
        for(int i=1;i<=maxSize;i++)
        {
            for(int j=1;j<=i;j++)
            {
                
            }
        }
    
    }
    private char[] increment(char[] cSet)
    {
        if(cSet[cSet.length]=='64')
        {
            
        }
    }
    
}
