/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Workers.RemoteWorker;
import java.util.ArrayList;

/**
 *
 * @author Bhargab
 */
public class WorkersRecord {
    private int totalOnline;
    public ArrayList<RemoteWorker> workers;
    public int getNum()
    {
        return workers.size();
    }
    
}
