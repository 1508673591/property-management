package com.YuXiuHui.modules.cms.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 栏目
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
public class ColumnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;

	private String code;
	// 栏目名称
	private String columnName;

	private String link;
	// 父栏目
	private Integer parentId;
	// 排序
	private String sort;
	// 店铺id
	private Long storeId;

	private List<ColumnEntity> children;

	private Integer status;

	private String tenantId;

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
	 * 设置：栏目名称
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * 获取：栏目名称
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * 设置：父栏目
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：父栏目
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * 设置：排序
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 获取：排序
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * 设置：店铺id
	 */
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	/**
	 * 获取：店铺id
	 */
	public Long getStoreId() {
		return storeId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<ColumnEntity> getChildren() {
		return children;
	}

	public void setChildren(List<ColumnEntity> children) {
		this.children = children;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
