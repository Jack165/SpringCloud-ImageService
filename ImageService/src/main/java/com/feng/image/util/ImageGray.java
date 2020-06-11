package com.feng.image.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.imageio.ImageIO;


public class ImageGray {
	private static int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

}
	public void gray(InputStream in,OutputStream os) throws IOException {

		 BufferedImage bufferedImage
	        = ImageIO.read(in);
	    BufferedImage grayImage =
	        new BufferedImage(bufferedImage.getWidth(),
	                          bufferedImage.getHeight(),
	                          bufferedImage.getType());


	    for (int i = 0; i < bufferedImage.getWidth(); i++) {
	        for (int j = 0; j < bufferedImage.getHeight(); j++) {
	            final int color = bufferedImage.getRGB(i, j);
	            final int r = (color >> 16) & 0xff;
	            final int g = (color >> 8) & 0xff;
	            final int b = color & 0xff;
	            int gray = (int) (0.299 * r + 0.587 * g + 0.114 * b);;
	            int newPixel = colorToRGB(255, gray, gray, gray);
	            grayImage.setRGB(i, j, newPixel);
	        }
	    }
	    
	    ImageIO.write(grayImage, "jpg", os);
	}
	
	public static void main(String[] args) throws IOException {
		
		File infile=new File("/Users/feng/Documents/18-003.jpg");

		File outFile=new File("/Users/feng/Documents/18-004.jpg");
		ImageGray i=new ImageGray();
		//i.gray(infile,outFile);
	}

}
