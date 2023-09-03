package com.waterspringer.commonutils.oss.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * @author Robert17
 * @create2022-11-08-15:29
 */

public interface OssService
{
     String uploadFileAvatar(MultipartFile file);
}
