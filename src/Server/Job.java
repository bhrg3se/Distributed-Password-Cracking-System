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
    public String hash;
    public String choices;
    public int maxLen;
    public String algo;
    public String salt;
    public String saltPos;
 //   public int jobID;
    public Job(String hash,String algo,String charset,int maxLen,String salt,String saltPos)
    {
        this.hash=hash;
        choices=charset;
        this.maxLen=maxLen;
        this.algo=algo;
        this.salt=salt;
        this.saltPos=saltPos;
        
        
    }
}
