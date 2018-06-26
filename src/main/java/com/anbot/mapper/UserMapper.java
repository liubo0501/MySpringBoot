package com.anbot.mapper;

import org.apache.ibatis.annotations.Param;

import com.anbot.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Short userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Short userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

    User selectByNameDns(@Param("userName") String userName,@Param("dns") String dns);
}