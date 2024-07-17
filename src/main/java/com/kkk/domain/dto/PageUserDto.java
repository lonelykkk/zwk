package com.kkk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/17 16:10
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUserDto {

    private String name;

    private int page;
    private int pageSize;
}
