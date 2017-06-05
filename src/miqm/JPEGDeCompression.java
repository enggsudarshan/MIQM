/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miqm;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;


public class JPEGDeCompression
  {



  public  void compressImage(BufferedImage image, float quality) throws IOException
    {
    
   /*
    Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");



    if (!writers.hasNext()) throw new IllegalStateException("No writers found");
    ImageWriter writer = (ImageWriter) writers.next();
    // Create the ImageWriteParam to compress the image.
    ImageWriteParam param = writer.getDefaultWriteParam();
    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    param.setCompressionQuality(quality);
    // The output will be a ByteArrayOutputStream (in memory)
    ByteArrayOutputStream bos = new ByteArrayOutputStream(32768);
    ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
    writer.setOutput(ios);
    writer.write(null, new IIOImage(image, null, null), param);
    ios.flush(); // otherwise the buffer size will be zero!
    // From the ByteArrayOutputStream create a RenderedImage.
    ByteArrayInputStream in = new ByteArrayInputStream(bos.toByteArray());
    RenderedImage out = ImageIO.read(in);
    int size = bos.toByteArray().length;
    SavingImage si=new SavingImage();
    si.saveJPG((Image) out, "C://compressed.jpg");

*/
    Iterator<ImageReader> readers = ImageIO.getImageReadersBySuffix("jpeg");
    if(!readers.hasNext())throw new IllegalStateException("No Reader found");

    ImageReader reader =(ImageReader)readers.next();
    ImageReadParam param=reader.getDefaultReadParam();
    param.setDestination(image);


    








    }



  }