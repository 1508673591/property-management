package com.YuXiuHui.modules.property.service;

import com.YuXiuHui.modules.property.entity.PayEntity;

import java.util.List;
import java.util.Map;

/**
 * 缴费
 * 
 * @author lizhengle
 * 
 */
public interface PayService {
	
	PayEntity queryObject(Integer id);
	
	List<PayEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PayEntity pay);
	
	void update(PayEntity pay);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<Map<String, String>> queryPaySum();
}
