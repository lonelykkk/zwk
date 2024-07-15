package com.kkk.service.impl;

import com.kkk.utils.AliOssUtil;
import com.kkk.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/5 13:57
 * @Version V1.0
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private AliOssUtil aliOssUtil;

    public String upload(MultipartFile img) {
        log.info("file：{}", img);
        try {
            //原始文件名
            String originalFilename = img.getOriginalFilename();
            //截取原始文件名的后缀   dfdfdf.png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名称
            String objectName = UUID.randomUUID().toString() + extension;

            //文件的请求路径
            String filePath = aliOssUtil.upload(img.getBytes(), objectName);
            return filePath;
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
            throw new RuntimeException("文件上传失败");
        }
    }
}
