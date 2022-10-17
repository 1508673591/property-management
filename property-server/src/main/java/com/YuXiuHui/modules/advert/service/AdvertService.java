package com.YuXiuHui.modules.advert.service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.advert.entity.AdvertEntity;


/**
 * 
 * @author GDUFSlqm
 * 
 */
public interface AdvertService {
	
	AdvertEntity queryObject(Integer id);
	
	List<AdvertEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AdvertEntity advert);
	
	void update(AdvertEntity advert);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
