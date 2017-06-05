/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miqm;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Dilip
 */
public class JPEGDeCoder
{


    public void decom(String path,double scale) throws IOException
    {
        try
        {

            FileInputStream fs = new FileInputStream(path);
             BufferedImage img = ImageIO.read(new File(path));
            BufferedImage image2 = null;



             JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(fs);
     BufferedImage srcImg = decoder.decodeAsBufferedImage();
    fs.close();



    AffineTransform af =AffineTransform.getScaleInstance(scale, scale );
    Map hints = new HashMap();
    hints.put(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
    RenderingHints rh = new RenderingHints(hints);
    AffineTransformOp transform = new AffineTransformOp(af,rh);
    transform.createCompatibleDestImage(srcImg, srcImg.getColorModel());




          
           int h=img.getHeight();
           int w=img.getWidth();

           System.out.println(h);
           System.out.println(w);


           int h1=(int) ((h * 100) / (scale * 100));
           int w1= (int)( (w*100)  /  (scale*100));




        image2=new BufferedImage(w1,h1,img.getType());
      Graphics2D gr2 = image2.createGraphics();
      gr2.drawImage(img,0,0,w1,h1,0,0,w,h,null);
      gr2.dispose();
      ImageIO.write(image2, "jpg", new File("C://MIQM_DeCompressed_Result.jpg"));
        }
        catch(Exception e)
        {
            
        }

    }
}
