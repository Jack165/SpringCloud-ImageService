package com.feng.image.model.factory;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPImageImpl implements IImageFatory{

	
	@Override
	public String getType() {
		
		return "bmp";
	}

	@Override
	public File outFile(String type) {
		File newFile=new File("/temp/"+type);
	
		try {
			ImageIO.write(getBuffImage(), type, newFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(newFile.exists()) {
			return newFile;
		}else {
			return null;
		}
	
	}

	@Override
	public BufferedImage getBuffImage() {
		BufferedImage picture =new BufferedImage(100,100, Image.SCALE_SMOOTH);
		return picture;
	}



}
