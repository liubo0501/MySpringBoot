package com.anbot.model;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/******************************************************************************** 
** Copyright(c) 2014-2017 湖南万为智能机器人技术有限公司 All Rights Reserved. 
** @author liubo@anbot.cn
** 日期： 2017/11/10
** 描述：请求参数
** 版本：v1.0
*********************************************************************************/
public class RequestParam {
	
	/**
	 * 事件名
	 */
    private String event;

    /**
     * token值
     */
    private String token;

    /**
     * 参数
     */
    private JSONObject param;
    
    /**
     * 文件路径集合
     */
    private Map<String,String> pathMap;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JSONObject getParam() {
        return param;
    }

    public void setParam(JSONObject param) {
        this.param = param;
    }

	public Map<String,String> getPathMap() {
		return pathMap;
	}

	public void setPathMap(Map<String,String> pathMap) {
		this.pathMap = pathMap;
	}
}
