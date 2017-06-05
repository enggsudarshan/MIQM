/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Perspective;

import java.awt.image.BufferedImage;

/**
 *
 * @author Dilip
 */
public class PerspectiveScaler
{
public float getFactor(BufferedImage img1,BufferedImage img2)
    {
      int w1=img1.getWidth();
      int w2=img2.getWidth();

      System.out.println("Width1 is "+w1);
      System.out.println("Width2 is "+w2);


      int diff=w2-w1;


       System.out.println("Diff is  "+diff);
       PerspectiveReConstrucor.diff=diff;


      float per1=(float) diff/w1;

      System.out.println("Per1 is "+per1);

      float per=per1*100;

         System.out.println("Per is "+per);

      
      return per;





    }
}
