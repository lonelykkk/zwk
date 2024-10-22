package com.kkk.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/9/26 16:26
 * @Version V1.0
 */
@Data
public class AiChatVo {
    @ApiModelProperty("问题")
    private String question;
    @ApiModelProperty("回答")
    private String answer;
    @ApiModelProperty("创建时间")
    private Date createTime;
}
