package com.kkk.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/16 14:10
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {

    private long total;

    private List records;
}
