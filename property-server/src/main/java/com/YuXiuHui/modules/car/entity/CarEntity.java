package com.YuXiuHui.modules.car.entity;

import java.io.Serializable;
import java.util.Date;

import com.YuXiuHui.modules.member.entity.MemberEntity;



/**
 * 车俩
 * 
 * @author lizhengle
 * 
 */
public class CarEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户id
	private Integer memberId;
	//车牌号
	private String carNo;
	//汽车品牌
	private String brand;
	//创建时间
	private Date createTime;
	
	private MemberEntity member;

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
	 * 设置：用户id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getMemberId() {
		return memberId;
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
	 * 设置：汽车品牌
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * 获取：汽车品牌
	 */
	public String getBrand() {
		return brand;
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
	
	public MemberEntity getMember() {
		return member;
	}
	
	public void setMember(MemberEntity member) {
		this.member = member;
	}
	
	
}
