package com.anbot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.anbot.model.RequestParam;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfaceServerBootApplicationTests {

	@Test
	public void contextLoads() {
		RequestParam param = new RequestParam();
		param.setEvent("haha");
		param.setToken("1233");
		System.out.println(JSON.toJSONString(param));
		
		String data = "{\"event\":\"login\",\"param\":{\"platform\":\"1\",\"username\":\"liubo@anbot.cn\",\"password\":\"6846860684f05029abccc09a53cd66f1\"}}";
	    param = JSONObject.parseObject(data, RequestParam.class);
	}

}
