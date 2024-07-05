package com.kkk.domain.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2024/7/5 10:09
 * @Version V1.0
 */
@Data
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",notes = "")
    private String username;
    @ApiModelProperty(value = "密码",notes = "")
    private String password;
}