package com.YuXiuHui.modules.house.service;

import com.YuXiuHui.modules.house.entity.HouseEntity;

import java.util.List;
import java.util.Map;

/**
 * 房屋
 * 
 * @author lizhengle
 * 
 */
public interface HouseService {
	
	HouseEntity queryObject(Integer id);
	
	List<HouseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HouseEntity house);
	
	void update(HouseEntity house);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
