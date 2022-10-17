package com.YuXiuHui.modules.car.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 车位
 * 
 * @author lizhengle
 * 
 */
public class ParkingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//车位编号
	private String parkingNo;
	//车牌号
	private String carNo;
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
	 * 设置：车位编号
	 */
	public void setParkingNo(String parkingNo) {
		this.parkingNo = parkingNo;
	}
	/**
	 * 获取：车位编号
	 */
	public String getParkingNo() {
		return parkingNo;
	}
	/**
	 * 设置：车牌号
	 */
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	/**
	 * 获取：车牌号
	 */
	public String getCarNo() {
		return carNo;
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
