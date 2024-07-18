package com.kkk.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 18/7/2024 上午 10:23
 * @Version V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo {
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 文章内容
     */
    @ApiModelProperty("文章内容")
    private String content;
    /**
     * 文章摘要
     */
    @ApiModelProperty("文章摘要")
    private String summary;
    /**
     * 所属分类id
     */
    @ApiModelProperty("分类名")
    private String categoryName;

    @ApiModelProperty("文章标签")
    private List<String> tagName;
    /**
     * 缩略图
     */
    @ApiModelProperty("缩略图")
    private String thumbnail;
    /**
     * 访问量
     */
    @ApiModelProperty("访问量")
    private Long viewCount;
    /**
     * 是否允许评论 1是，0否
     */
    @ApiModelProperty("")
    private Long createBy;
    /**
     *
     */
    @ApiModelProperty("")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     *
     */
    @ApiModelProperty("")
    private Long updateBy;
    /**
     *
     */
    @ApiModelProperty("")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
