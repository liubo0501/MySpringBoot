package com.anbot.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anbot.common.Constant;
import com.anbot.model.RequestParam;
import com.anbot.model.ResponseParam;
/******************************************************************************** 
** Copyright(c) 2014-2017 湖南万为智能机器人技术有限公司 All Rights Reserved. 
** @author  liubo@anbot.cn
** 日期： 2017/11/10
** 描述：thrift工具类
** 版本：v1.0
*********************************************************************************/
public class ThriftUtil {
	/**
     * 日志
     */  
    private static Logger logger = LoggerFactory.getLogger(ThriftUtil.class);
    
	/**
     * 调用Thrift客户端执行
     * 
     * @param responseParam
     *            响应参数
     * @param requestParam
     *            请求参数
     * @return 响应结果
     */
    public static void execThrift(ResponseParam responseParam, RequestParam requestParam) {
//        //从池中取一个可用连接
//        ThriftClient thriftClient = ThriftPoolFactoryUtil.getConnection();
//        if(thriftClient == null){
//        	String message = "调用Thrift客户端失败,请联系管理员";
//        	responseParam.setStatusCode(Constant.STATUSCODE_SYNTAXRRROR);
//            responseParam.setStatusInfo(message);
//            logger.error(message);
//            return ;
//        }
//        String event = requestParam.getEvent();
//        String result =null;
//        try {
//            //创建Client  
//            Client client = thriftClient.getClient();  
//            result = client.httpRequest(JSON.toJSONString(requestParam));
//            if(result == null){
//              	String message = event + "调用Thrift接口返回的result是null";
//            	responseParam.setStatusCode(Constant.STATUSCODE_SYNTAXRRROR);
//                responseParam.setStatusInfo(message);
//                logger.error(message);
//                return responseParam;
//            }
//            // JSON转换成响应参数对象
//            responseParam = JSONObject.parseObject(result, ResponseParam.class);
//        } catch (Exception e) {
//        	logger.error("result:{}",result);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();  
//            e.printStackTrace(new PrintStream(baos));  
//            String exception = baos.toString();
//            String message = event + "{}调用Thrift接口报错：" + exception;
//        	responseParam.setStatusCode(Constant.STATUSCODE_SYNTAXRRROR);
//            responseParam.setStatusInfo(message);
//            logger.error(message);
//            ThriftPoolFactoryUtil.invalidateObject(thriftClient);
//            thriftClient = null;
//            return responseParam;
//        } finally {
//            if (thriftClient != null) {
//                logger.debug("{}释放Thrift连接", event);
//                // 记得每次用完，要将连接释放
//                ThriftPoolFactoryUtil.releaseConnection(thriftClient);
//            }
//        }
    }
}
