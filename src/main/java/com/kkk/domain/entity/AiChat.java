package com.kkk.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* 
* @TableName ai_chat
*/
@Data
public class AiChat implements Serializable {

    /**
    * 主键id
    */
    @NotNull(message="[主键id]不能为空")
    @ApiModelProperty("主键id")
    private Long id;
    /**
    * 问题
    */
    @NotBlank(message="[问题]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("问题")
    private String question;
    /**
    * 回答
    */
    @NotBlank(message="[回答]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("回答")
    private String answer;
    /**
    * 用户id
    */
    @ApiModelProperty("用户id")
    private Long userId;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("列表id")
    private Long listId;

}
