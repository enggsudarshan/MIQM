/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NewApproach;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dilip
 */
public class NewMIQM
{

    public boolean applyMIQM(BufferedImage img2,String param)
    {



try {


  String [] t=param.split(",");
  int r=Integer.parseInt(t[0]);
  int g=Integer.parseInt(t[1]);
  int b=Integer.parseInt(t[2]);


    System.out.println("Printing in NEW miqm Operation ");
    System.out.println(r +" "+g+" "+b);




   int h=img2.getHeight();
   int w=img2.getWidth();
   BufferedImage fin=null;

   for(int i=0;i<w;i++)
   {
       for(int j=0;j<h;j++)
       {


int rgb = img2.getRGB(i, j);

//then assign them an int value
int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;

red=red+r;
green=green+g;
blue=blue+b;
if(red>=255)
{
    red=255;
}
 else if(red<0)
{
    red=0;

 }


if(green>=255)
{
    green=255;
}
else if(green<0)
{
    green=0;

 }
if(blue>=255)
{
    blue=255;
}
else if(blue<0)
{
    blue=0;

 }




           Color pix = new Color(red,  green,  blue); // Color white
          int rgb1=pix.getRGB();
     img2.setRGB(i, j, rgb1);

       }

  }

       ImageIO.write(img2, "jpg", new File("C://newmiqm.jpg"));


       return true;

            }

        catch (IOException ex)
        {
          System.out.println("Exception is "+ex);

          return false;
        }


    }


}
