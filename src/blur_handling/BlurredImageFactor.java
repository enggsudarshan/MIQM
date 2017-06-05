/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blur_handling;

import java.awt.image.BufferedImage;

public class BlurredImageFactor
{
public int getValue(BufferedImage image)
    {


int w = image.getWidth();
int h = image.getHeight();
System.out.println("Width is :"+w);
System.out.println("Height is :"+h);
int rgb = image.getRGB(w/2, h/2);

int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;
int s1=red+green+blue;
//System.out.println(red+ " "+green+" "+blue);


int rgb1 = image.getRGB(w/2, 0);

int red1 = (rgb1 >> 16) & 0x000000FF;
int green1 = (rgb1 >> 8 ) & 0x000000FF;
int blue1 = (rgb1) & 0x000000FF;
int s2=red1+green1+blue1;
//System.out.println(red1+ " "+green1+" "+blue1);

int diff=Math.abs(s1-s2);

System.out.println("Diff "+diff);



return diff;









    }
}
