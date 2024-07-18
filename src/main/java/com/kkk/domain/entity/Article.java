package com.kkk.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章表
 *
 * @TableName article
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    /**
     *
     */
    @NotNull(message = "[]不能为空")
    @ApiModelProperty("")
    private Long id;
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
    @ApiModelProperty("所属分类id")
    private Long categoryId;
    /**
     * 缩略图
     */
    @ApiModelProperty("缩略图")
    private String thumbnail;
    /**
     * 是否置顶（0否，1是）
     */
    @ApiModelProperty("是否置顶（0否，1是）")
    private String isTop;
    /**
     * 状态（0已发布，1草稿）
     */
    @ApiModelProperty("状态（0已发布，1草稿）")
    private String status;
    /**
     * 访问量
     */
    @ApiModelProperty("访问量")
    private Long viewCount;
    /**
     * 是否允许评论 1是，0否
     */
    @ApiModelProperty("是否允许评论 1是，0否")
    private String isComment;
    /**
     *
     */
    @ApiModelProperty("")
    private Long createBy;
    /**
     *
     */
    @ApiModelProperty("")
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
    private Date updateTime;
    /**
     * 删除标志（0代表未删除，1代表已删除）
     */
    @ApiModelProperty("删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;


}
