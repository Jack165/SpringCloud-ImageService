package com.feng.image.model.factory;

import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 图片输出工厂
 * @author feng
 *
 */
public interface IImageFatory {
	
	//当前类型
	String getType();
	
	BufferedImage getBuffImage();
	//输出指定类型到文件
	File outFile(String type);
	
}
