package com.YuXiuHui.modules.car.service;

import com.YuXiuHui.modules.car.entity.CarEntity;

import java.util.List;
import java.util.Map;

/**
 * 车俩
 * 
 * @author lizhengle
 * 
 */
public interface CarService {
	
	CarEntity queryObject(Integer id);
	
	List<CarEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CarEntity car);
	
	void update(CarEntity car);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
