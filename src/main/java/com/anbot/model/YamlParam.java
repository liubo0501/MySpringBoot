package com.anbot.model;

import java.util.List;

/******************************************************************************** 
** Copyright(c) 2014-2017 湖南万为智能机器人技术有限公司 All Rights Reserved. 
** @author liubo@anbot.cn
** 日期： 2017/11/10
** 描述：yaml配置文件属性集合
** 版本：v1.0
*********************************************************************************/
public class YamlParam {
	
    private String image;
    
    private Double resolution;
    
    private List<Double> origin;

    private Integer negate;
    
    private Double occupied_thresh;
    
    private Double free_thresh;
    
    public Double getResolution() {
        return resolution;
    }

    public void setResolution(Double resolution) {
        this.resolution = resolution;
    }

    public List<Double> getOrigin() {
        return origin;
    }

    public void setOrigin(List<Double> origin) {
        this.origin = origin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNegate() {
		return negate;
	}

	public void setNegate(Integer negate) {
		this.negate = negate;
	}

	public Double getOccupied_thresh() {
		return occupied_thresh;
	}

	public void setOccupied_thresh(Double occupied_thresh) {
		this.occupied_thresh = occupied_thresh;
	}

	public Double getFree_thresh() {
		return free_thresh;
	}

	public void setFree_thresh(Double free_thresh) {
		this.free_thresh = free_thresh;
	}

	@Override
    public String toString() {
        return "YamlParam [image=" + image + ", resolution=" + resolution + ", origin=" + origin +  "]";
    }
    
}
