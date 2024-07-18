package com.kkk.service;

import com.kkk.domain.dto.PageArticleDto;
import com.kkk.domain.vo.ArticleVo;

import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/17 17:40
 * @Version V1.0
 */
public interface ArticleService {
    List<ArticleVo> page(PageArticleDto pageArticleDto);
}
