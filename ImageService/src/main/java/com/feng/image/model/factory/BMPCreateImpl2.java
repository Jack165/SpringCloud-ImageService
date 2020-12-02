package com.feng.image.model.factory;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPCreateImpl2 implements IcreateImageFactory{

	@Override
	public File create(String path) {
		File file=new File(path);
		try {
			ImageIO.write(new BufferedImage(200,200, Image.SCALE_AREA_AVERAGING), "BMP", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(file.exists()) {
			return file;
		}
		return null;
	}
	

}
