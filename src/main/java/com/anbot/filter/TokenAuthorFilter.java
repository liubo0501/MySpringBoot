package com.anbot.filter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.anbot.common.Constant;
import com.anbot.model.ResponseParam;
import com.anbot.util.JWTUtil;
@Component
@WebFilter("/httpRequest/*")
public class TokenAuthorFilter implements Filter {
	 private static Logger logger = LoggerFactory.getLogger(TokenAuthorFilter.class);
	 
	 @Autowired
	 private com.anbot.model.MyProps myProps;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        //设置允许跨域的配置
        // 这里填写你允许进行跨域的主机ip（正式上线时可以动态配置具体允许的域名和IP）
        rep.setHeader("Access-Control-Allow-Origin", "*");
        // 允许的访问方法
        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        // Access-Control-Max-Age 用于 CORS 相关配置的缓存
        rep.setHeader("Access-Control-Max-Age", "3600");
        rep.setHeader("Access-Control-Allow-Headers","token,Origin, X-Requested-With, Content-Type, Accept");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String token = req.getHeader("token");//header方式
        String event = req.getHeader("event");//事件名
        ResponseParam resultInfo = new ResponseParam();
        boolean isFilter = false;

		// 在列表中进行token验证
		if (myProps.getIngorelist().contains(event)) {
            rep.setStatus(HttpServletResponse.SC_OK);
            isFilter = true;
        }else{
            if (null == token || token.isEmpty()) {
                resultInfo.setStatusCode(Constant.STATUSCODE_FORBIDDEN);
                resultInfo.setStatusInfo("客户端请求参数中无token信息");
            } else {
                if (JWTUtil.volidateToken(token)) {
                    resultInfo.setStatusCode(Constant.STATUSCODE_SUCCESS);
                    resultInfo.setStatusInfo("用户授权认证通过!");
                    isFilter = true;
                } else {
                    resultInfo.setStatusCode(Constant.STATUSCODE_FORBIDDEN);
                    resultInfo.setStatusInfo("用户授权认证没有通过!");
                }
            }
            if (resultInfo.getStatusCode() == Constant.STATUSCODE_FORBIDDEN) {// 验证失败
                PrintWriter writer = null;
                OutputStreamWriter osw = null;
                try {
                    osw = new OutputStreamWriter(response.getOutputStream(),
                            "UTF-8");
                    writer = new PrintWriter(osw, true);
                    String jsonStr = JSON.toJSONString(resultInfo);
                    writer.write(jsonStr);
                    writer.flush();
                    writer.close();
                    osw.close();
                } catch (UnsupportedEncodingException e) {
                    logger.error("过滤器返回信息失败:" + e.getMessage(), e);
                } catch (IOException e) {
                    logger.error("过滤器返回信息失败:" + e.getMessage(), e);
                } finally {
                    if (null != writer) {
                        writer.close();
                    }
                    if (null != osw) {
                        osw.close();
                    }
                }
                return;
            }
        }
        if (isFilter) {
        logger.info("token filter过滤ok!");
        chain.doFilter(request, response);
        }
        
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
