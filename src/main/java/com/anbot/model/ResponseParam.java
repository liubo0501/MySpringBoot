package com.anbot.model;

/******************************************************************************** 
** Copyright(c) 2014-2017 湖南万为智能机器人技术有限公司 All Rights Reserved. 
** @author liubo@anbot.cn
** 日期： 2017/11/10
** 描述：响应参数
** 版本：v1.0
*********************************************************************************/
public class ResponseParam {
	/**
	 * 状态码
	 */
    private String statusCode;

    /**
     * 状态信息
     */
    private String statusInfo;

    /**
     * 参数
     */
    private Object param;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public  Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
}
