package com.feng.image.model.factory;

import java.io.File;

/**
 * 创建图片工厂
 * @author feng
 *
 */
public interface IcreateImageFactory {

	File create(String path);
	
	
}
