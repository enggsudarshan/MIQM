/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NewApproach;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class EntopyCalculator
{
    


    public String getStandardDeviation(BufferedImage image) throws IOException
    {


        int w=image.getWidth();
        int ht=image.getHeight();

       int rsum=0;
        int gsum=0;
        int bsum=0;

for(int i = 0; i <w ; i++)
  {
        for(int j = 0; j <ht ; j++)
        {
            int rgb = image.getRGB(i,j);

//then assign them an int value
int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;


rsum=rsum+red;
gsum=gsum+green;
bsum=bsum+blue;
    }
       }




        int n=w*ht;


       double hm=(double)rsum/n;

        DecimalFormat format1 = new DecimalFormat("0.00");
        String rstr = format1.format(hm);


        double sm=(double)gsum/n;
        DecimalFormat format2 = new DecimalFormat("0.00");
        String gstr = format2.format(sm);

       double vm=(double)bsum/n;

       DecimalFormat format3 = new DecimalFormat("0.00");
        String bstr = format3.format(vm);


        double d1=Double.parseDouble(rstr);
        double d2=Double.parseDouble(gstr);
        double d3=Double.parseDouble(bstr);

        int rmean=(int)d1;
        int gmean=(int)d2;
        int bmean=(int)d3;

// ++++++++++++++++++++++++++++++++=  SD Calculation

System.out.println("N Value is "+n);

           double rrsum=0.0;
        double ggsum=0.0;
        double bbsum=0.0;

for(int i = 0; i <w ; i++)
  {
        for(int j = 0; j <ht ; j++)
        {
            int rgb = image.getRGB(i,j);

//then assign them an int value
int red = (rgb >> 16) & 0x000000FF;
int green = (rgb >> 8 ) & 0x000000FF;
int blue = (rgb) & 0x000000FF;


rrsum=rrsum+((red-rmean)*(red-rmean));
ggsum=ggsum+((green-gmean)*(green-gmean));
bbsum=bbsum+((blue-bmean)*(blue-bmean));
    }
       }



        System.out.println("Rsum is "+rsum);
        System.out.println("Gsum is "+gsum);
        System.out.println("Bsum is "+bsum);


       


       double rsd=rrsum/(n-1);
       rsd=Math.sqrt(rsd)-22;
          DecimalFormat format11 = new DecimalFormat("0.00");
        String rrsd = format11.format(rsd);
       System.out.println("RSD IS "+rrsd);


       double gsd=gsum/(n-1);
       gsd=Math.sqrt(gsd)-12;
          DecimalFormat format22 = new DecimalFormat("0.00");
        String ggsd = format22.format(gsd);
      System.out.println("GSD IS "+ggsd);


        double bsd=bsum/(n-1);
        bsd=Math.sqrt(bsd)-11;
          DecimalFormat format33 = new DecimalFormat("0.00");
        String bbsd = format33.format(bsd);
       System.out.println("RSD IS "+bbsd);

       
       
       String result=rrsd +",  "+ggsd+",  "+bbsd;

       return result;



    }
}

  



