package com.YuXiuHui.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.YuXiuHui.modules.member.entity.MemberEntity;


/**
 * 消息
 * 
 * @author lizhengle
 * 
 */
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//标题
	private String title;
	//内容
	private String content;
	//创建时间
	private Date createTime;
	
	private Long userId;
	
	private MemberEntity user;
	
	private Integer status;

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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
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
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public MemberEntity getUser() {
		return user;
	}
	
	public void setUser(MemberEntity user) {
		this.user = user;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
