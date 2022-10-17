package com.YuXiuHui.modules.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.YuXiuHui.modules.member.entity.MemberEntity;
import com.YuXiuHui.modules.sys.dao.BaseDao;


/**
 * 用户
 * 
 * @author GDUFSlqm
 * 
 */
@Mapper
public interface MemberDao extends BaseDao<MemberEntity> {

	MemberEntity queryByOpenid(String openid);

	MemberEntity queryByLoginName(String loginName);
}
