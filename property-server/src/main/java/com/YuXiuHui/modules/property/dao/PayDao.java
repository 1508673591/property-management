package com.YuXiuHui.modules.property.dao;

import com.YuXiuHui.modules.property.entity.PayEntity;
import com.YuXiuHui.modules.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 缴费
 * 
 * @author lizhengle
 * 
 */
@Mapper
public interface PayDao extends BaseDao<PayEntity> {

	List<Map<String, String>> queryPaySum();
	
}
