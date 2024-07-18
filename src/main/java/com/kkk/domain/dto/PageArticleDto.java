package com.kkk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 18/7/2024 上午 9:36
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageArticleDto {

    private String title;

    private Long categoryId;
}
