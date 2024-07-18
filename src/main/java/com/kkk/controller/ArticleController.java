package com.kkk.controller;

import com.kkk.domain.dto.PageArticleDto;
import com.kkk.domain.vo.ArticleVo;
import com.kkk.service.ArticleService;
import com.kkk.utils.PageResult;
import com.kkk.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/17 17:32
 * @Version V1.0
 */
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("/list")
    public Result getArticleList(PageArticleDto pageArticleDto) {
        List<ArticleVo> articleVos = articleService.page(pageArticleDto);

        return Result.okResult(articleVos);
    }

}
