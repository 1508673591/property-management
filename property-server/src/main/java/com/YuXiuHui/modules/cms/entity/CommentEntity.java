package com.YuXiuHui.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.YuXiuHui.modules.member.entity.MemberEntity;

/**
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 主键
	private Integer id;
	// 会员id
	private Long memberId;
	// 文章id
	private Integer articleId;
	// 评论
	private String content;
	// 创建时间

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;
	
	private MemberEntity member;
	
	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：会员id
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取：会员id
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * 设置：文章id
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	/**
	 * 获取：文章id
	 */
	public Integer getArticleId() {
		return articleId;
	}

	/**
	 * 设置：评论
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取：评论
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

}
