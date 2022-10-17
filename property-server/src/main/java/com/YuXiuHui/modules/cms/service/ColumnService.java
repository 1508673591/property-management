package com.YuXiuHui.modules.cms.service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.cms.entity.ColumnEntity;

/**
 * 栏目
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
public interface ColumnService {
	
	ColumnEntity queryObject(Integer id);
	
	List<ColumnEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ColumnEntity column);
	
	void update(ColumnEntity column);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
