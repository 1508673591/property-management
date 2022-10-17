package com.YuXiuHui.modules.repair.entity;

import java.io.Serializable;


/**
 * 报修图片
 * 
 * @author lizhengle
 * 
 */
public class RepairPicEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Integer repairId;
	//
	private String picUrl;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setRepairId(Integer repairId) {
		this.repairId = repairId;
	}
	/**
	 * 获取：
	 */
	public Integer getRepairId() {
		return repairId;
	}
	/**
	 * 设置：
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	/**
	 * 获取：
	 */
	public String getPicUrl() {
		return picUrl;
	}
}
