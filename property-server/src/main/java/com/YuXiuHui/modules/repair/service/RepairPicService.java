package com.YuXiuHui.modules.repair.service;

import com.YuXiuHui.modules.repair.entity.RepairPicEntity;

import java.util.List;
import java.util.Map;

/**
 * 报修图片
 * 
 * @author lizhengle
 * 
 */
public interface RepairPicService {
	
	RepairPicEntity queryObject(Integer id);
	
	List<RepairPicEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(RepairPicEntity repairPic);
	
	void update(RepairPicEntity repairPic);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
