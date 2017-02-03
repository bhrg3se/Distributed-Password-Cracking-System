/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers;

/**
 *
 * @author Bhargab
 */
public class Main {
    public static void main(String[] args) {
        Communicator c=new Communicator("127.0.0.1", 1234);
        c.start();
    }
    
}
