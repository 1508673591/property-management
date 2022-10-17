package com.YuXiuHui.modules.car.service;

import com.YuXiuHui.modules.car.entity.ParkingEntity;

import java.util.List;
import java.util.Map;

/**
 * 车位
 * 
 * @author lizhengle
 * 
 */
public interface ParkingService {
	
	ParkingEntity queryObject(Integer id);
	
	List<ParkingEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ParkingEntity parking);
	
	void update(ParkingEntity parking);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
