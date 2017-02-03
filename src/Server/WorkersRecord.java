/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Bhargab
 */
public class WorkersRecord {
    private int totalOnline;
    public ArrayList<Worker> workers;
    public WorkersRecord()
    {
        workers=new ArrayList<Worker>();
    }
    public int getNum()
    {
        return workers.size();
    }
    
}
