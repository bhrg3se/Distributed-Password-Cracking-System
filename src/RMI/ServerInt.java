/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;

/**
 *
 * @author Bhargab
 */
public interface ServerInt extends Remote{
    public void completed(String pass);
    
}
