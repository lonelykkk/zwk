package com.kkk.controller;

import com.kkk.common.utils.Result;
import com.kkk.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
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
@RestController("/upload")
@Log4j2
public class FileUploadController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result upload(MultipartFile img) {
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
            return Result.okResult(filePath);
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
        }
        return Result.errorResult(507, "文件上传失败");
    }
}
