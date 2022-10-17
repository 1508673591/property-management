package com.YuXiuHui.modules.house.entity;

import java.io.Serializable;
import java.util.Date;

import com.YuXiuHui.modules.member.entity.MemberEntity;



/**
 * 房屋
 * 
 * @author lizhengle
 * 
 */
public class HouseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//楼宇id
	private Integer buildingId;
	//房屋编号
	private String houseNo;
	//用户id
	private Integer memberId;
	//户型
	private Integer houseType;
	//面积
	private Float area;
	//备注
	private String remark;
	//创建时间
	private Date createTime;
	
	private MemberEntity member;
	
	private BuildingEntity building;

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
	 * 设置：楼宇id
	 */
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	/**
	 * 获取：楼宇id
	 */
	public Integer getBuildingId() {
		return buildingId;
	}
	/**
	 * 设置：房屋编号
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	/**
	 * 获取：房屋编号
	 */
	public String getHouseNo() {
		return houseNo;
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
	 * 设置：户型
	 */
	public void setHouseType(Integer houseType) {
		this.houseType = houseType;
	}
	/**
	 * 获取：户型
	 */
	public Integer getHouseType() {
		return houseType;
	}
	/**
	 * 设置：面积
	 */
	public void setArea(Float area) {
		this.area = area;
	}
	/**
	 * 获取：面积
	 */
	public Float getArea() {
		return area;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
	
	public BuildingEntity getBuilding() {
		return building;
	}
	
	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}
	
	
}
