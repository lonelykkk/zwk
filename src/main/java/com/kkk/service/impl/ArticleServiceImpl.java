package com.kkk.service.impl;

import com.kkk.domain.dto.PageArticleDto;
import com.kkk.domain.vo.ArticleVo;
import com.kkk.mapper.ArticleMapper;
import com.kkk.service.ArticleService;
import com.kkk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/17 17:40
 * @Version V1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryService categoryService;


    @Override
    public List<ArticleVo> page(PageArticleDto pageArticleDto) {
        //查询文章表的基本信息
        List<ArticleVo> articleVos = articleMapper.queryList(pageArticleDto);

        return articleVos;
    }
}
