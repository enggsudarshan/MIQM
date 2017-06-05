/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miqm;

import java.awt.image.BufferedImage;

public class RotatedImageFactor
{
public float getValue(BufferedImage image)
    {


int w = image.getWidth();
int h = image.getHeight();
int adj=0;
for(int y = 0; y < h; y++)
{


int rgb = image.getRGB(0, y);

int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;
if(red==0 && green==0 && blue==0)
{
    adj++;
}
 else
{
    break;
 }

//System.out.println(red+ " "+green+" "+blue);

   
     }



// calculation of opposit



int opp=0;
for(int x = 0; x < w; x++)
{


int rgb = image.getRGB(x, 0);

int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;
if(red==0 && green==0 && blue==0)
{
    opp++;
}
 else
{
    break;
 }

//System.out.println(red+ " "+green+" "+blue);


     }

System.out.println("Adjacent "+adj);
System.out.println("Opposite "+ opp);

float a=(adj*adj)+(opp*opp);
float hyp=(float) Math.sqrt(a);

float p=(float)adj/hyp;

float deg=(float) (Math.acos(p) * 180 / Math.PI);
//deg=    (float) (deg - 1.57);
System.out.println("Angle is :"+deg);
return deg;




    }
}
