package com.anbot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anbot.model.RequestParam;
import com.anbot.model.ResponseParam;
import com.anbot.service.BaseService;

@RestController
public class MainController {

	@Autowired
    public Map<String,BaseService> serviceMap;
	
	@RequestMapping("/httpRequest")
	// {"event":"login","param":{"platform":"1","username":"liubo@anbot.cn","password":"6846860684f05029abccc09a53cd66f1"}}  不要data postman 选raw JSON
	public ResponseParam main(@RequestBody RequestParam data){
		BaseService service = serviceMap.get(data.getEvent());
		return service.exec(data);
	}
}
