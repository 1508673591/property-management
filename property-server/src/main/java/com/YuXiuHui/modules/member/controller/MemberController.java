package com.YuXiuHui.modules.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.member.entity.MemberEntity;
import com.YuXiuHui.modules.member.service.MemberService;


/**
 * 用户
 * 
 * @author GDUFSlqm
 * 
 */
@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/listAll")
	public R listAll(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<MemberEntity> memberList = memberService.queryList(params);
		return R.ok().put("memberList", memberList);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MemberEntity> memberList = memberService.queryList(query);
		int total = memberService.queryTotal(query);
		return R.ok().put("rows", memberList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.queryObject(id);
		return R.ok().put("member", member);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody MemberEntity member){
		memberService.save(member);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody MemberEntity member){
		memberService.update(member);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		memberService.deleteBatch(ids);
		return R.ok();
	}
	
}
