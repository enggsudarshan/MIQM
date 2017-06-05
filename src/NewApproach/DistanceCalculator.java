/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NewApproach;

import java.util.ArrayList;

public class DistanceCalculator
{

    public String  getMeanDiscatnce(ArrayList m1,ArrayList m2)
    {
      //  ArrayList mas=new ArrayList();

        String r1=(String)m1.get(0);
           String g1=(String)m1.get(1);
           String b1=(String)m1.get(2);



            String r2=(String)m2.get(0);
           String g2=(String)m2.get(1);
           String b2=(String)m2.get(2);


           double a=Double.parseDouble(r1);
           double b=Double.parseDouble(g1);
           double c=Double.parseDouble(b1);



            double x=Double.parseDouble(r2);
           double y=Double.parseDouble(g2);
           double z=Double.parseDouble(b2);





           double rr1=a-x;
           double gg1=b-y;
           double bb1=c-z;


           int ir=(int) rr1;
           int ig=(int) gg1;
           int ib=(int) bb1;

         


             String res=ir+ ","+ig+","+ib;
           
           System.out.println(res);
           return res;








    }
}
