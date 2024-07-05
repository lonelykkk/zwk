package com.kkk.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/5 13:56
 * @Version V1.0
 */
public interface FileUploadService {

    public String upload(MultipartFile img);
}
