package com.YuXiuHui.modules.repair.service;

import com.YuXiuHui.modules.repair.entity.RepairEntity;

import java.util.List;
import java.util.Map;

/**
 * 报修
 * 
 * @author lizhengle
 * 
 */
public interface RepairService {
	
	RepairEntity queryObject(Integer id);
	
	List<RepairEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RepairEntity repair);
	
	void update(RepairEntity repair);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void complete(Integer[] ids);

	List<Map<String, Object>> queryCount();
}
