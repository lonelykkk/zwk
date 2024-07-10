package com.kkk.domain.vo;

import com.kkk.domain.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginVo {

    @ApiModelProperty("token令牌")
    private String token;
    @ApiModelProperty("用户信息")
    private User user;
}
