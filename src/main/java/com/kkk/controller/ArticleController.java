package com.kkk.controller;

import com.kkk.domain.dto.PageArticleDto;
import com.kkk.domain.vo.ArticleVo;
import com.kkk.service.ArticleService;
import com.kkk.utils.PageResult;
import com.kkk.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/17 17:32
 * @Version V1.0
 */
@Api(value = "用户端文章查询相关接口")
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("查看文章列表")
    @GetMapping("/list")
    public Result getArticleList(PageArticleDto pageArticleDto) {
        List<ArticleVo> articleVos = articleService.page(pageArticleDto);
        return Result.okResult(articleVos);
    }

    @ApiOperation("根据文章id查询文章详情")
    @GetMapping("/{id}")
    public Result getArticleById(@PathVariable Long id) {
        ArticleVo article = articleService.getById(id);
        return Result.okResult(article);
    }

}
