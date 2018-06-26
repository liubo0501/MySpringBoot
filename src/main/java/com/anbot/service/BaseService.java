package com.anbot.service;

import com.anbot.model.RequestParam;
import com.anbot.model.ResponseParam;

public interface BaseService {
	
	ResponseParam exec(RequestParam param);

}
