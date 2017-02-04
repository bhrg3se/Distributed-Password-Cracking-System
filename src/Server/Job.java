/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Bhargab
 */
public class Job {
    public byte[] hash;
    public String choices;
    public int maxLen;
    public String userName;
 //   public int jobID;
    public Job(byte[] aHash,String ch,int maxL,String userName)
    {
        hash=aHash.clone();
        choices=ch;
        maxLen=maxL;
        this.userName=userName;
    }
}
