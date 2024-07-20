package com.kkk.service.impl;

import com.kkk.domain.dto.PageArticleDto;
import com.kkk.domain.vo.ArticleVo;
import com.kkk.mapper.ArticleMapper;
import com.kkk.mapper.TagMapper;
import com.kkk.service.ArticleService;
import com.kkk.service.CategoryService;
import com.kkk.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private TagMapper tagMapper;


    /**
     * 查看文章列表
     * @param pageArticleDto
     * @return
     */
    @Override
    public List<ArticleVo> page(PageArticleDto pageArticleDto) {
        //查询文章表的基本信息
        List<ArticleVo> articleVos = articleMapper.queryList(pageArticleDto);
        return articleVos;
    }

    @Override
    public ArticleVo getById(Long id) {
        //先根据id查询文章信息
        ArticleVo articleVo = articleMapper.getArticleById(id);

        //获取对应文章的标签列表
        List<Long> tagIds = articleMapper.getTagIds(id);
        List<String> tagNames = new ArrayList<>();
        for (Long tagId : tagIds) {
            String tagName = tagMapper.getNameById(tagId);
            tagNames.add(tagName);
        }
        articleVo.setTagName(tagNames);
        return articleVo;
    }
}
