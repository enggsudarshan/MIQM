

package miqm;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Rotator

{
public  BufferedImage rotate(BufferedImage img, int angle) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = dimg = new BufferedImage(w+100, h+100, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.rotate(Math.toRadians(angle), w/2, h/2);
       
        g.drawImage(img, null, 50, 50);
        return dimg;
    }
}
