package com.YuXiuHui.modules.repair.entity;

import java.io.Serializable;
import java.util.Date;

import com.YuXiuHui.modules.member.entity.MemberEntity;



/**
 * 报修
 * 
 * @author lizhengle
 * 
 */
public class RepairEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户id
	private Long memberId;
	//姓名
	private String realName;
	//电话
	private String mobile;
	//地点
	private String address;
	//问题描述
	private String content;
	//状态
	private Integer status;
	//备注
	private String remark;
	//创建时间
	private Date createTime;
	
	private String[] picUrls;
	
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
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getMemberId() {
		return memberId;
	}
	/**
	 * 设置：姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：姓名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：地点
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地点
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：问题描述
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：问题描述
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
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
	
	public String[] getPicUrls() {
		return picUrls;
	}
	
	public void setPicUrls(String[] picUrls) {
		this.picUrls = picUrls;
	}
	
	public MemberEntity getMember() {
		return member;
	}
	
	public void setMember(MemberEntity member) {
		this.member = member;
	}
	
}
