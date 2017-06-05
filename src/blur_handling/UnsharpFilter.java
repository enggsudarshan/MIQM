/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package blur_handling;

import java.awt.image.*;

public class UnsharpFilter extends GaussianFilter
{
protected Kernel kernel1;
    public static float rt=(float) 0.0;
	private float amount = 0.5f;
	private int threshold = 1;
    private boolean premultiplyAlpha=true;
        protected float radius1;

	public UnsharpFilter() {
		radius1 = rt;
                kernel1 = makeKernel(radius1);
                  System.out.println("Kernel at Unsharp Filter is "+kernel);

              
	}

     //Set the threshold value.
    //@param threshold the threshold value
    // @see #getThreshold
     
	public void setThreshold( int threshold ) {
		this.threshold = threshold;
	}


     // Get the threshold value.
     //@return the threshold value
     //@see #setThreshold
     //
	public int getThreshold() {
		return threshold;
	}

	
	// * Set the amount of sharpening.
	 //* @param amount the amount
    // * @min-value 0
    // * @max-value 1
   //  * @see #getAmount
	// */
	public void setAmount( float amount ) {
		this.amount = amount;
	}

	/**
	 * Get the amount of sharpening.
	 * @return the amount
     * @see #setAmount
	 */
	public float getAmount() {
		return amount;
	}

//  public BufferedImage filter( BufferedImage src, BufferedImage dst )
        public BufferedImage filter( BufferedImage src )
    {


BufferedImage dst = null;
        int width = src.getWidth();
        int height = src.getHeight();

        if ( dst == null )
            dst = createCompatibleDestImage( src, null );

        int[] inPixels = new int[width*height];
        int[] outPixels = new int[width*height];
        src.getRGB( 0, 0, width, height, inPixels, 0, width );

		if ( radius1 > 0 ) {
			convolveAndTranspose(kernel1, inPixels, outPixels, width, height, alpha, alpha && premultiplyAlpha, false, CLAMP_EDGES);
			convolveAndTranspose(kernel1, outPixels, inPixels, height, width, alpha, false, alpha && premultiplyAlpha, CLAMP_EDGES);

                        	
		}

        src.getRGB( 0, 0, width, height, outPixels, 0, width );

		float a = 4*amount;

		int index = 0;
		for ( int y = 0; y < height; y++ ) {
			for ( int x = 0; x < width; x++ ) {
				int rgb1 = outPixels[index];
				int r1 = (rgb1 >> 16) & 0xff;
				int g1 = (rgb1 >> 8) & 0xff;
				int b1 = rgb1 & 0xff;

				int rgb2 = inPixels[index];
				int r2 = (rgb2 >> 16) & 0xff;
				int g2 = (rgb2 >> 8) & 0xff;
				int b2 = rgb2 & 0xff;

				if ( Math.abs( r1 -  r2 ) >= threshold )
					r1 = PixelUtils.clamp( (int)((a+1) * (r1-r2) + r2) );
				if ( Math.abs( g1 -  g2 ) >= threshold )
					g1 = PixelUtils.clamp( (int)((a+1) * (g1-g2) + g2) );
				if ( Math.abs( b1 -  b2 ) >= threshold )
					b1 = PixelUtils.clamp( (int)((a+1) * (b1-b2) + b2) );

				inPixels[index] = (rgb1 & 0xff000000) | (r1 << 16) | (g1 << 8) | b1;
				index++;
			}
		}

        dst.setRGB( 0, 0, width, height, inPixels, 0, width );
        return dst;
    }

	public String toString() {
		return "Blur/Unsharp Mask...";
	}


        public static void convolveAndTranspose(Kernel kernel1, int[] inPixels, int[] outPixels, int width, int height, boolean alpha, boolean premultiply, boolean unpremultiply, int edgeAction)
        {
		float[] matrix = kernel1.getKernelData( null );
		int cols = kernel1.getWidth();
		int cols2 = cols/2;

		for (int y = 0; y < height; y++) {
			int index = y;
			int ioffset = y*width;
			for (int x = 0; x < width; x++) {
				float r = 0, g = 0, b = 0, a = 0;
				int moffset = cols2;
				for (int col = -cols2; col <= cols2; col++) {
					float f = matrix[moffset+col];

					if (f != 0) {
						int ix = x+col;
						if ( ix < 0 ) {
							if ( edgeAction == CLAMP_EDGES )
								ix = 0;
							else if ( edgeAction == WRAP_EDGES )
								ix = (x+width) % width;
						} else if ( ix >= width) {
							if ( edgeAction == CLAMP_EDGES )
								ix = width-1;
							else if ( edgeAction == WRAP_EDGES )
								ix = (x+width) % width;
						}
						int rgb = inPixels[ioffset+ix];
						int pa = (rgb >> 24) & 0xff;
						int pr = (rgb >> 16) & 0xff;
						int pg = (rgb >> 8) & 0xff;
						int pb = rgb & 0xff;
						if ( premultiply ) {
							float a255 = pa * (1.0f / 255.0f);
							pr *= a255;
							pg *= a255;
							pb *= a255;
						}
						a += f * pa;
						r += f * pr;
						g += f * pg;
						b += f * pb;
					}
				}
				if ( unpremultiply && a != 0 && a != 255 ) {
					float f = 255.0f / a;
					r *= f;
					g *= f;
					b *= f;
				}
				int ia = alpha ? PixelUtils.clamp((int)(a+0.5)) : 0xff;
				int ir = PixelUtils.clamp((int)(r+0.5));
				int ig = PixelUtils.clamp((int)(g+0.5));
				int ib = PixelUtils.clamp((int)(b+0.5));
				outPixels[index] = (ia << 24) | (ir << 16) | (ig << 8) | ib;
                index += height;
			}
		}
	}
}
