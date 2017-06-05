/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NewApproach;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class MeanCalculator
{



    public ArrayList getMean(BufferedImage image) throws IOException
    {

        ArrayList mean=new ArrayList();

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


      // String hstr=Double.toString(hm);
       //String sstr=Double.toString(sm);
       //String vstr=Double.toString(vm);

      // String result=hstr+",  "+sstr+",  "+vstr;

      // return result;

       mean.add(rstr);
       mean.add(gstr);
       mean.add(bstr);

       return mean;




    }
}





