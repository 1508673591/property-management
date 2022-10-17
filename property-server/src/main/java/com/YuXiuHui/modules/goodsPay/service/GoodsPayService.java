package com.YuXiuHui.modules.goodsPay.service;

import com.YuXiuHui.modules.goodsPay.entity.GoodsPayEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author GDUFSlqm
 * 
 */
public interface GoodsPayService {
	
	GoodsPayEntity queryObject(Long id);
	
	List<GoodsPayEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsPayEntity goodsPay);
	
	void update(GoodsPayEntity goodsPay);
	
	void delete(Long id);
	
	void deleteBatch(Integer[] ids);


}
