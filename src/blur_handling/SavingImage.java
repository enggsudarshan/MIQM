/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blur_handling;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
/**
 *
 * @author Dilip
 */
public class SavingImage
{
 public void saveJPG(Image img, String s)
 {
        BufferedImage bi= new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=bi.createGraphics();
        g2.drawImage(img, null, null);
        FileOutputStream out=null;
        try{
            out = new FileOutputStream(s);
        }
        catch(java.io.FileNotFoundException ex){
            ex.printStackTrace();
        }
        JPEGImageEncoder encoder= JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param= encoder.getDefaultJPEGEncodeParam(bi);
        param.setQuality(0.5f, false);
        encoder.setJPEGEncodeParam(param);
        try{
            encoder.encode(bi);
            out.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
