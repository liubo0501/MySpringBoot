package com.anbot.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component    
@ConfigurationProperties(prefix="myprops")
public class MyProps {
	 private List<String> ingorelist = new ArrayList<>(); //接收prop2里面的属性值    
	 
	 private long tokenTime;

	public List<String> getIngorelist() {
		return ingorelist;
	}

	public void setIngorelist(List<String> ingorelist) {
		this.ingorelist = ingorelist;
	}

	public long getTokenTime() {
		return tokenTime;
	}

	public void setTokenTime(long tokenTime) {
		this.tokenTime = tokenTime;
	}
}
