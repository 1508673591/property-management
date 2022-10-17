package com.YuXiuHui.modules.goodsPay.entity;

import com.YuXiuHui.modules.member.entity.MemberEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 
 * @author GDUFSlqm
 *
 */
public class GoodsPayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//
	private Integer goodsId;
	//用户id
	private Integer memberId;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	//
	private MemberEntity member;

	public GoodsPayEntity( Integer goodsId, Integer memberId) {

		this.goodsId = goodsId;
		this.memberId = memberId;

	}

	public GoodsPayEntity( ) {




	}
}
