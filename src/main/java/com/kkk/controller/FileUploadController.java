package com.kkk.controller;

import com.kkk.common.utils.Result;
import com.kkk.common.utils.AliOssUtil;
import com.kkk.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传相关接口
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/5 10:42
 * @Version V1.0
 */
@Api(tags = "文件上传接口")
@RestController
@Log4j2
public class FileUploadController {


    @Autowired
    private FileUploadService uploadService;

    /**
     * 文件上传
     * @param img
     * @return
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result upload(MultipartFile img) {

        log.info("文件file：{}", img);
        String filePath = uploadService.upload(img);
        return Result.okResult(filePath);
    }
}
