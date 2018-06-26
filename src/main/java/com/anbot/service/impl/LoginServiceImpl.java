package com.anbot.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anbot.common.Constant;
import com.anbot.common.DataCache;
import com.anbot.mapper.TokenMapper;
import com.anbot.mapper.UserMapper;
import com.anbot.model.MyProps;
import com.anbot.model.RequestParam;
import com.anbot.model.ResponseParam;
import com.anbot.model.Token;
import com.anbot.model.User;
import com.anbot.service.BaseService;
import com.anbot.thrift.ThriftClient;
import com.anbot.util.JWTUtil;
import com.anbot.util.ThriftUtil;

@Service("login")
public class LoginServiceImpl implements BaseService {
	private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private MyProps myProps;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TokenMapper tokenMapper;
	@Autowired
	private ThriftClient thriftClient;
	
	@Override
	public ResponseParam exec(RequestParam requestParam) {
		  logger.info("login start");
	        // 参数
	        JSONObject param = requestParam.getParam();
	        // 用户名
	        String userName = param.getString("username");
			String[] strs= userName.split("@");
			userName = strs[0];
			try {
				thriftClient.open();
				String result = thriftClient.getThriftService().httpRequest(JSON.toJSONString(requestParam));
				logger.info("result {}",result);
			} catch (TTransportException e) {
				e.printStackTrace();
			} catch (TException e) {
				e.printStackTrace();
			}finally{
				thriftClient.close();
			}
			
	        // 接口返回参数
	        logger.info("login开始调用Thrift接口");
	        ResponseParam responseParam = new ResponseParam();
	        
	        
	        ThriftUtil.execThrift(responseParam,requestParam);
	        
	        responseParam.setStatusCode(Constant.STATUSCODE_SUCCESS);
	        // 登录成功
	        if (Constant.STATUSCODE_SUCCESS.equals(responseParam.getStatusCode())) {
	            logger.info("Thrift登录成功，开始token的处理");
	            // 获取用户
	            User user = userMapper.selectByNameDns(userName,strs[1]);
	            // 用户存在
	            if (null != user) {
	            	// 用户Id
	            	Integer userId = user.getUserId();
	                // 平台类型
	            	Integer platform = param.getInteger("platform");
	                // 生成Token
	                String tokenValue = JWTUtil.createJWT(userName,myProps.getTokenTime());
                    // token插入到数据库中
	                Token token = new Token();
	                token.setUserId(userId);
	                token.setPlatformType(platform);
	                token.setTime(new Date());
	                token.setValue(tokenValue);
	                tokenMapper.insert(token);
	                DataCache.tokenMap.put(userName, tokenValue);
	                logger.info("登录token值是："+ tokenValue);
	                // 设置token值到返回参数
                    Map<String, Object> map = new HashMap<String, Object>(1);
                    map.put("token", tokenValue);
                    responseParam.setParam(map);
	        }
	        logger.info("login end，返回的结果是：{}",JSONObject.toJSONString(responseParam));
	}
	        return responseParam;
}
}