/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.util.LinkedList;

/**
 *
 * @author Bhargab
 */
public class Main {
    public static void main(String[] args) {
        Job j=new Job();
        j.hash="7d3aba21871bbdcd07ad85608857c651f4a06254";
        j.maxLen=4;
        j.userName="bhrg3se";
        LinkedList l=new LinkedList();
        l.add(j);
        WorkersRecord wr= new WorkersRecord();
        WorkerHandler wh=new WorkerHandler(wr, l);
        Scheduler s=new Scheduler(l, wr);
        wh.start();
        s.start();
    }
    
}
