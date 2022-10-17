package com.YuXiuHui.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 主键
	private Integer id;
	// 标题
	private String title;
	// 摘要
	private String summary;
	//
	private String picUrl;
	//
	private String content;
	// 点赞数量
	private Integer likedNum = 0;
	// 评论数量
	private Integer commentNum = 0;
	// 发布时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date publishDate;

	private Boolean liked;

	private Integer type;

	private String videoUrl;

	private String vid;

	private Long storeId;

	private Integer columnId;

	private String columnName;

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
	 * 设置：摘要
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * 获取：摘要
	 */
	public String getSummary() {
		return summary;
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

	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置：点赞数量
	 */
	public void setLikedNum(Integer likedNum) {
		this.likedNum = likedNum;
	}

	/**
	 * 获取：点赞数量
	 */
	public Integer getLikedNum() {
		return likedNum;
	}

	/**
	 * 设置：评论数量
	 */
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	/**
	 * 获取：评论数量
	 */
	public Integer getCommentNum() {
		return commentNum;
	}

	/**
	 * 设置：发布时间
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * 获取：发布时间
	 */
	public Date getPublishDate() {
		return publishDate;
	}

	public Boolean getLiked() {
		return liked;
	}

	public void setLiked(Boolean liked) {
		this.liked = liked;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

}
