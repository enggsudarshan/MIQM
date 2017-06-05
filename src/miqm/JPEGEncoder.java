/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miqm;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

public class JPEGEncoder
{


    public void comp(String path,double p)
          {

        try
        {
            BufferedImage img = ImageIO.read(new File(path));
            BufferedImage image2;


             Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");
    if (!writers.hasNext()) throw new IllegalStateException("No writers found");
    ImageWriter writer = (ImageWriter) writers.next();
    // Create the ImageWriteParam to compress the image.
    ImageWriteParam param = writer.getDefaultWriteParam();
    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    param.setCompressionQuality((float) p);


   FileOutputStream out = new FileOutputStream(path);
    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out,JPEGCodec.getDefaultJPEGEncodeParam(img));
    encoder.encode(img);
    out.close();
       


           int h=img.getHeight();
           int w=img.getWidth();

           int h1=(int) (h * p);
           int w1=(int) (w * p);






        image2=new BufferedImage(w1,h1,img.getType());
      Graphics2D gr2 = image2.createGraphics();
      gr2.drawImage(img,0,0,w1,h1,0,0,w,h,null);
      gr2.dispose();
          ImageIO.write(image2, "jpg", new File("C://Compressed_Image.jpg"));
              }
        catch(Exception e)
        {
            
        }
    

    }
}
