package com.kkk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkk.domain.dto.PageArticleDto;
import com.kkk.domain.entity.Article;
import com.kkk.domain.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/17 17:38
 * @Version V1.0
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<ArticleVo> queryList(PageArticleDto pageArticleDto);

    List<Long> getTagIds(Long id);

    ArticleVo getArticleById(Long id);
}
