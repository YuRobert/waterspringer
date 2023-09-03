package com.waterspringer.iot_datashow.controller;


import com.alibaba.fastjson.JSONObject;
import com.waterspringer.commonutils.ResponseResult;
import com.waterspringer.commonutils.map.BaiduMapGeocoderUtil;
import com.waterspringer.commonutils.oss.service.OssService;
import com.waterspringer.commonutils.oss.service.impl.OssServiceImpl;
import lombok.AllArgsConstructor;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Robert
 * @since 2023-07-22
 */
@RestController
@RequestMapping("/iot_datashow/company-information")
public class CompanyInformationController {

    @Autowired
    private OssService ossService;
    @GetMapping("/hello")
    public ResponseResult hello()
    {
        String s = BaiduMapGeocoderUtil.getAddressInfoByLngAndLat("117", "39");
        return ResponseResult.ok().message(s);

    }

    private FileItem getMultipartFile(File file, String fieldName){
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem item = factory.createItem(fieldName, "text/plain", true, file.getName());
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

}

