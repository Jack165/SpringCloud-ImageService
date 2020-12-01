package com.feng.image.util.picture;

import java.io.IOException;

/**
 * 操作图片类
 * @author feng
 *
 */
public class ImageDataUtils {

	/**
	 * 
	 * @param imgFile 原始图片路径
	 * @param data   需要加入图片中的数据路径
	 * @param newImgFile  需要生成新的图片的路径
	 */
	public static void addDateTopicture(String imgFile, String data, String newImgFile) {

		try {
			CoreExecute.DataSourceToBMP(data, imgFile, newImgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param imgFile 隐藏有数据的图片
	 * @param dataFile 将图片隐藏的数据取出来的路径
	 */
	 public static void revData(String imgFile,String dataFile) {
	
		    try {
		    	CoreExecute.BMPToDataSource(imgFile, dataFile);
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
		  }

}
