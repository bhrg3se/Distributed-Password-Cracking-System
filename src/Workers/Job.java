/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

import Server.*;
import java.io.Serializable;

/**
 *
 * @author Bhargab
 */
public class Job implements Serializable{
    public String hash;
    public String choices;
    public int maxLen;
    public String userName;
    public int jobID;
    public int start;
    public int end;
    
}
