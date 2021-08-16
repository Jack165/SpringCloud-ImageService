package com.feng.image.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OCRUtil {
	
	
	
	public static ITesseract iTesseract;
	public static ITesseract getItessITesseract() {
		if(null==iTesseract) {
			iTesseract= new Tesseract();	
			iTesseract.setLanguage("chi_sim");
			iTesseract.setDatapath("/opt/tessdata");
		}
		return iTesseract;
	}
	
	public  static String getOcrText(InputStream is) {
		String ocrText="ocr识别失败";
		try {
			BufferedImage bi=ImageIO.read(is);
			ocrText=getItessITesseract().doOCR(bi);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ocrText);
		return ocrText;
	}
	
	
	  public static void main(String[] args) throws IOException, Exception {
	        System.out.println("识别");
	        // 1.创建 ITesseract 图片识别类
	        ITesseract instance = new Tesseract();
	        String lagnguagePath = "D:\\tessdata";
	        if(args.length>0) {
	        	lagnguagePath=args[0];
	        }
	        instance.setDatapath(lagnguagePath);
	        instance.setLanguage("chi_sim+eng");
	        String jpgFile="D://qq.png";
	        if(args.length>1) {
	        	jpgFile=args[1];
	        }
	        // 2.创建文件
	        File newFile = new File(jpgFile);
	        BufferedImage bm= ImageUtil.zoomInImage(ImageIO.read(newFile),5);
	        
	        bm=ImageUtil.grayImage(bm);
	        bm=ImageUtil.binaryImage(bm);
	        bm=ImageUtil.denoise(bm);
	        
	        // 3.开始识别
	            String codeString;
				try {
					ImageUtil.writImage(bm,"d:/qb.jpg");
					codeString = instance.doOCR(bm);
				ImageUtil.writImage(bm,"d:/qb.jpg");
					System.out.println("识别内容是:" + codeString);
				} catch (TesseractException e) {
					e.printStackTrace();
				}
	    }
	  
	  
	  
}
