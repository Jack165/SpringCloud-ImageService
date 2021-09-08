package com.feng.image.util;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.FileInputStream;
import java.io.InputStream;

public class OssUtil {

    final static String ossUrl_index="http://oss.feixingtianxia.cn/";

    public static   String upload(String name, InputStream fileIs){
        Configuration cfg = new Configuration();
        cfg.useHttpsDomains = false;
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "testestetetes";
        String secretKey = "keytestetetetetetet";
        String bucket = "feixingtianxia";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "D:\\house.jar";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "house.jar";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            System.out.println(response.bodyString());
            return ossUrl_index+name;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

        return null;

    }



}
