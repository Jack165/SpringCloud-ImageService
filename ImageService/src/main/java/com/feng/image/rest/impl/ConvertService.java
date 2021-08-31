package com.feng.image.rest.impl;

import com.alibaba.fastjson.JSONObject;
import com.feng.image.model.factory.IImageFatory;
import com.feng.image.util.ImageUtil;
import com.feng.image.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Api("转换接口")
@Controller
public class ConvertService {
    @Autowired
    List<IImageFatory> iImageFatoryList;
    @ApiOperation(value = "测试信息", notes = "测试")
    @PostMapping("/convert/img")
    @ResponseBody
    public String getInfo(String fileBase64Str,String targetType) throws IOException {

        File file = null;
        for(IImageFatory iImageFatory:iImageFatoryList){
            if(iImageFatory.getType().equals(targetType)){
                file= iImageFatory.outFile(targetType);
                break;
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        BufferedImage bi= ImageIO.read(file);
        ImageIO.write(bi, targetType, stream);
        byte[] bytes=stream.toByteArray();
        String base64String= Base64.encodeBase64String(bytes);

        return base64String;

    }



}
