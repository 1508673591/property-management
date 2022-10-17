package com.YuXiuHui.modules.property.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.YuXiuHui.modules.member.entity.MemberEntity;



/**
 * 缴费
 * 
 * @author lizhengle
 * 
 */
public class PayEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户id
	private Long memberId;
	//金额
	private BigDecimal amount;
	//类型
	private Integer type;
	//时间
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
	 * 设置：金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：时间
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
