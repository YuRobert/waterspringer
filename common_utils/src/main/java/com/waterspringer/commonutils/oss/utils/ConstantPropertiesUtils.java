//package com.waterspringer.commonutils.oss.utils;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @author Robert17
// * @create2022-11-08-15:14
// */
//@Component
//public class ConstantPropertiesUtils implements InitializingBean
//{
//    @Value("${aliyun.oss.file.endpoint}")
//    private String endPoint;
//    @Value("${aliyun.oss.file.keyid}")
//    private String keyId;
//    @Value("${aliyun.oss.file.keysecret}")
//    private String keySecret;
//    @Value("${aliyun.oss.file.bucketname}")
//    private String bucketName;
//    @Value("${aliyun.oss.file.filehost}")
//    private String hostName;
//
//
//    //定义公开静态常量
//    public static String END_POINT;
//    public static String KEY_ID;
//    public static String KEY_SECRET;
//    public static String BUCKET_NAME;
//    public static String File_HOST;
//
//    @Override
//    public void afterPropertiesSet() throws Exception
//    {
//        END_POINT = endPoint;
//        KEY_ID = keyId;
//        KEY_SECRET = keySecret;
//        BUCKET_NAME = bucketName;
//    }
//}