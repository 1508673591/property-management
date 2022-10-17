package com.YuXiuHui.modules.sys.dao;


import com.YuXiuHui.modules.sys.entity.SysUserEntity;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 * 
 * @author GDUFSlqm
 * 
 */
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {
	
	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);
	
	/**
	 * 修改密码
	 */
	int updatePassword(Map<String, Object> map);
}
