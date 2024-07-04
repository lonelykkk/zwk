package com.kkk.domain.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class ChatAskDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer chatId;

    private String content;

}
