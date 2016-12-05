/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bhrg3se;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opencl.CL;
import org.lwjgl.opencl.CL10;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLPlatform;

class Main 
{
    public static void main(String[] args) {
        try {
            CL.create();
            CLPlatform platform = CLPlatform.getPlatforms().get(0); 
            List<CLDevice> devices=platform.getDevices(CL10.CL_DEVICE_TYPE_ALL);
            CLContext context=CLContext.create(platform, devices, null);
            
            System.out.println(context);
        } catch (LWJGLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}