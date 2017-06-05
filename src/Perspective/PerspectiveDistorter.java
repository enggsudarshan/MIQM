/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Perspective;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dilip
 */
public class PerspectiveDistorter
{

    public void constructImage(BufferedImage img,int per) throws IOException
    {

        System.out.println("Entered Percntage is "+per);
        int h=img.getHeight();
      int w=img.getWidth();

      System.out.println("Total Width of the original Image is "+w);
      System.out.println("Total Height of the original Image is "+h);


       int t=w/2;
       int p=(w/100)*per;
       int fw=t+p;   // increaded width
       int finalwidth=w-fw;

       int ffw=w+p;  // added width of the final resulted image
 System.out.println("Percentage Pixel is "+p);

    // creating first half

      BufferedImage image1=new BufferedImage(w/2,h,img.getType());
      Graphics2D gr1 = image1.createGraphics();
      gr1.drawImage(img,0,0,w/2,h,0,0,w/2,h,null);
      gr1.dispose();
     // ImageIO.write(image1, "jpg", new File("C://MIQM_Images//sama.jpg"));

  // creating second half is

        System.out.println("Exact half is :"+t);
        System.out.println("Increase width of the second half  is :"+fw);
       System.out.println("Final Width is :"+finalwidth);

      BufferedImage image2=new BufferedImage(fw,h,img.getType());
      Graphics2D gr2 = image2.createGraphics();
      gr2.drawImage(img,0,0,fw,h,finalwidth,0,w,h,null);
      gr2.dispose();
     // ImageIO.write(image2, "jpg", new File("C://MIQM_Images//sam2.jpg"));

      BufferedImage bi=attachImages(image1,image2);
       ImageIO.write(bi, "jpg", new File("C://perspective_distortion.jpg"));






    }

    public BufferedImage attachImages(BufferedImage img1, BufferedImage img2) throws IOException
{
        BufferedImage resultImage = new BufferedImage(img1.getWidth() +
                img2.getWidth(), img1.getHeight() ,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = resultImage.getGraphics();
        g.drawImage(img1, 0, 0, null);
        g.drawImage(img2, img1.getWidth(), 0, null);
       return resultImage;

        
        

}


}
