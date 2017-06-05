/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package miqm;

import java.awt.image.BufferedImage;

/**
 *
 * @author Dilip
 */
public class CompressionQualityMeasurer
{

    public double measureFactors ( BufferedImage img1,BufferedImage img2)
    {
        int w1=img1.getWidth();
        int w2=img2.getWidth();

          double val=(w2*100)/w1;

          val=val/100;


          return val;
        


        

    }



}
