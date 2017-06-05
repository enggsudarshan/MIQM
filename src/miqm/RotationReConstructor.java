/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miqm;

import Perspective.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class RotationReConstructor
{
    public static int diff=0;


    public void scaleImage(BufferedImage image1,BufferedImage image2,double angle) throws IOException
    {
      //int h=image1.getHeight();
      int w1=image1.getWidth();
      int w2=image2.getWidth();

      int h1=image1.getHeight();


      System.out.println("Width1 is ----------"+w1);
      System.out.println("Width2 is  ----------"+w2);

     
int d=w2-w1;

      int count=0;

      int pos=0;

    
for(int x = 0; x < w1; x++)
{
    

int rgb = image1.getRGB(x, 0);

int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;

   int rgb2= image2.getRGB(x, 0);

int red1 = (rgb2 >> 16) & 0x000000FF;
int green1 = (rgb2 >> 8 ) & 0x000000FF;
int blue1 = (rgb2) & 0x000000FF;


if(red!=red1 && green!=green1 && blue!=blue1)
{
    count++;
    if(count==1)
    {

        pos=x;   // blcak Counting
    }

}
}

      System.out.println("Count is ------------------ "+count);



      // connstructing first half


        BufferedImage img1=new BufferedImage(w1,h1,image1.getType());
      Graphics2D gr1 = img1.createGraphics();
    
      gr1.drawImage(image1,0,0,w1,h1,0,0,w1,h1,null);
      gr1.dispose();
        
     ImageIO.write(img1, "jpg", new File("C://MIQM_Rotation_Result.jpg"));
    



 }

     

  
}


