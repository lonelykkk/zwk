package com.kkk.domain.entity;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 标签
* @TableName tag
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements Serializable {

    /**
    * 
    */
    @ApiModelProperty("")
    private Long id;
    /**
    * 标签名
    */
    @ApiModelProperty("标签名")
    private String name;
    /**
    * 
    */
    @ApiModelProperty("创建人")
    private Long createBy;
    /**
    * 
    */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 
    */
    @ApiModelProperty("更新人")
    private Long updateBy;
    /**
    * 
    */
    @ApiModelProperty("更新时间")
    private Date updateTime;
    /**
    * 删除标志（0代表未删除，1代表已删除）
    */
    @ApiModelProperty("删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;
    /**
    * 备注
    */
    @ApiModelProperty("备注")
    private String remark;

}
