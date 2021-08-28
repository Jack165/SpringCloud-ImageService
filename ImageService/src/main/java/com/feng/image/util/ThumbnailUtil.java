package com.feng.image.util;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 谷歌图片处理类
 */
public class ThumbnailUtil {
    public static String base64ToThumbnail(String base64Str, double wScale,double hScale){
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] bytes =  Base64.decodeBase64(base64Str);//解码，将base64字符串转出字节数组
        byte[] data = null;
        InputStream ins = null;
        ByteArrayOutputStream baos = null;
        try{
            ins = new ByteArrayInputStream(bytes);//将字节数组转出流对象
            baos = new ByteArrayOutputStream();
            Thumbnails.of(ins).scale(wScale, hScale).toOutputStream(baos);
            data = baos.toByteArray();
        }catch(Exception e){
            return null;
        }finally{
            try {
                if(ins!=null){ins.close();};
                if(baos!=null){baos.close();};
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String(encoder.encode(data));
    }
}
