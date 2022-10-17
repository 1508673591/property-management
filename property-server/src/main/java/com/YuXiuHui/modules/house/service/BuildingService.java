package com.YuXiuHui.modules.house.service;

import com.YuXiuHui.modules.house.entity.BuildingEntity;

import java.util.List;
import java.util.Map;

/**
 * 楼宇
 * 
 * @author lizhengle
 * 
 */
public interface BuildingService {
	
	BuildingEntity queryObject(Integer id);
	
	List<BuildingEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BuildingEntity building);
	
	void update(BuildingEntity building);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
