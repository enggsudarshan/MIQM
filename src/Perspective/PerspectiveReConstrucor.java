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
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class PerspectiveReConstrucor
{
    public static int diff=0;


    public void scaleImage(BufferedImage image1,BufferedImage image2) throws IOException
    {
      //int h=image1.getHeight();
      int w1=image1.getWidth();
      int w2=image2.getWidth();

      int h=image1.getHeight();


      System.out.println("Width1 is ----------"+w1);
      System.out.println("Width2 is  ----------"+w2);

     
int d=w2-w1;

      int count=0;

      int pos=0;

    
for(int x = 0; x < w1; x++)
{
    

int rgb = image1.getRGB(x, 0);

//then assign them an int value
int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;

   int rgb2= image2.getRGB(x, 0);

//then assign them an int value
int red1 = (rgb2 >> 16) & 0x000000FF;
int green1 = (rgb2 >> 8 ) & 0x000000FF;
int blue1 = (rgb2) & 0x000000FF;


if(red!=red1 && green!=green1 && blue!=blue1)
{
    count++;
    if(count==1)
    {

        System.out.println("Pos is "+x);
        pos=x;
    }

}
}

      System.out.println("Count is ------------------ "+count);



      // connstructing first half


        BufferedImage img1=new BufferedImage(w1/2,h,image2.getType());
      Graphics2D gr1 = img1.createGraphics();
    
      gr1.drawImage(image2,0,0,w1/2,h,0,0,w1/2,h,null);
      gr1.dispose();
        
    // ImageIO.write(img1, "jpg", new File("C://MIQM_Images//pappi.jpg"));
        //  System.out.println("Image Constructed");


     BufferedImage img2=new BufferedImage(w1/2,h,image2.getType());
      Graphics2D gr2 = img2.createGraphics();
      gr2.drawImage(image2,0,0,w1/2,h,w1/2+d,0,w2,h,null);
      gr2.dispose();
      //  ImageIO.write(img2, "jpg", new File("C://MIQM_Images//pappi2.jpg"));
      //   System.out.println("Second Image Constructed");




     BufferedImage bi=attachImages(img1,img2);
       ImageIO.write(bi, "jpg", new File("C://MIQM_Perspective_Result.jpg"));

        // System.out.println("Resulted  Image Constructed");




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


