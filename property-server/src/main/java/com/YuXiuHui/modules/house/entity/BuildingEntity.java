package com.YuXiuHui.modules.house.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 楼宇
 * 
 * @author lizhengle
 * 
 */
public class BuildingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//楼宇名称
	private String buildingName;
	//备注
	private String remarks;
	//创建时间
	private Date createTime;

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
	 * 设置：楼宇名称
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	/**
	 * 获取：楼宇名称
	 */
	public String getBuildingName() {
		return buildingName;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
