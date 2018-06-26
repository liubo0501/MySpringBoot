package com.anbot.mapper;

import com.anbot.model.Token;

public interface TokenMapper {
    int insert(Token record);

    int insertSelective(Token record);
}