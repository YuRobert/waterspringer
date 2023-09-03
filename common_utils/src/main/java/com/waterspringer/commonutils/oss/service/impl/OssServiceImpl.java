package com.waterspringer.commonutils.oss.service.impl;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.waterspringer.commonutils.oss.service.OssService;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Robert17
 * @create2022-11-08-15:29
 */
@Service
public class OssServiceImpl implements OssService
{
    @Override
    public String uploadFileAvatar(MultipartFile file)
    {
//        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//        String endpoint = ConstantPropertiesUtils.END_POINT;
//        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
//        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
//        // 填写Bucket名称，例如examplebucket。
//        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
//        String fileHost = ConstantPropertiesUtils.File_HOST;
//        aliyun.oss.file.endpoint=oss-cn-hangzhou.aliyuncs.com
//        aliyun.oss.file.keyid=LTAI5tE8LuETqQyr5bfh4dPx
//        aliyun.oss.file.keysecret=O9VrAI3k09HpahjrSbRVx3j5oVvC0g
//#bucket??????????????java????
//        aliyun.oss.file.bucketname=education-yuqi
//        aliyun.oss.file.filehost=filehost
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tE8LuETqQyr5bfh4dPx";
        String accessKeySecret = "O9VrAI3k09HpahjrSbRVx3j5oVvC0g";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "iot-vehicle";
        String fileHost = "filehost";
//        String fileHost = ConstantPropertiesUtils.File_HOST;
        //构建日期路径：avatar/2019/02/26/文件名
        String filePath = new DateTime().toString("yyyy/MM/dd");
        //文件名：uuid.扩展名
        String original = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String fileUrl = filePath + "/" + fileName + original ;
        String uploadUrl = "http://" + bucketName + "." + endpoint + "/" + fileUrl;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, fileUrl, inputStream);
            return uploadUrl;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if (ossClient != null) {
                ossClient.shutdown();
                return null;
            }
        }
        return null;
    }
}
