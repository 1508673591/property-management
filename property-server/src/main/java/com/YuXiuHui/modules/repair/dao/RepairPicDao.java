package com.YuXiuHui.modules.repair.dao;

import com.YuXiuHui.modules.repair.entity.RepairPicEntity;
import com.YuXiuHui.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 报修图片
 * 
 * @author lizhengle
 * 
 */
@Mapper
public interface RepairPicDao extends BaseDao<RepairPicEntity> {
	String[] queryByRepairId(Integer repairId);
}
