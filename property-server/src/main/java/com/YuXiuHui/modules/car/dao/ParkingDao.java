package com.YuXiuHui.modules.car.dao;

import com.YuXiuHui.modules.car.entity.ParkingEntity;
import com.YuXiuHui.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 车位
 * 
 * @author lizhengle
 * 
 */
@Mapper
public interface ParkingDao extends BaseDao<ParkingEntity> {
	
}
