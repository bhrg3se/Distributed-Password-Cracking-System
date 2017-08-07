/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import static Client.CMain.add;
import static Client.CMain.port;
import RMI.ServerInt;
import static Workers.Main.getIp;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.MessageDigest;
import java.util.Formatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author bhrg3se
 */
public class ConnectWorker extends SwingWorker<ServerInt, Object> {

    private String hash;
    private String algo;
    private String charset;
    private String salt;
    private String saltPos;
    private int maxLen;
    private String servAdd;
    private JPanel jPanel;
    private ServerInt srmi;
    private File dictFile;

    public ConnectWorker(String hash, String algo, String charset, int maxLen, String salt, String saltPos, String servAdd, JPanel jPanel, ServerInt srmi, File dictFile) {
        this.hash = hash;
        this.algo = algo;
        this.charset = charset;
        this.maxLen = maxLen;
        this.salt = salt;
        this.saltPos = saltPos;
        this.servAdd = servAdd;
        this.jPanel = jPanel;
        this.srmi = srmi;
        this.dictFile = dictFile;
    }

    @Override
    protected ServerInt doInBackground() throws Exception {
        //add = getIp();
        JLabel j = (JLabel) jPanel.getComponent(0);
        j.setText("Connecting");
        CardLayout cl = (CardLayout) jPanel.getParent().getLayout();
        cl.last(jPanel.getParent());
        // System.setProperty("java.rmi.server.hostname", add);

        srmi = (ServerInt) Naming.lookup("rmi://" + servAdd + ":8081/THE_SERVER");

        ClientRMI abc = new ClientRMI();

        Registry reg = LocateRegistry.createRegistry(5555);
        reg.rebind("abc", abc);

        srmi.addJob(hash, algo, charset, maxLen, salt, saltPos, 5555);
        
        
        MessageDigest m=MessageDigest.getInstance(algo);

        if (dictFile != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(dictFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if(byteArray2Hex(m.digest(line.getBytes())).equals(hash))
                            {
                                j.setText("Password is:"+line);
                                srmi.completed(line);
                                break;
                            }
                }
            }
        }

        return null;
    }
private static String byteArray2Hex(final byte[] hash) {
    Formatter formatter = new Formatter();
    for (byte b : hash) {
        formatter.format("%02x", b);
    }
    return formatter.toString();
}
}
