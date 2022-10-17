package com.YuXiuHui.modules.shopping.service;

import com.YuXiuHui.modules.shopping.entity.ShoppingEntity;

import java.util.List;
import java.util.Map;

/**
 * 房屋
 *
 * 
 */
public interface ShoppingService {
	
	ShoppingEntity queryObject(Integer id);
	
	List<ShoppingEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ShoppingEntity shopping);
	
	void update(ShoppingEntity shopping);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
