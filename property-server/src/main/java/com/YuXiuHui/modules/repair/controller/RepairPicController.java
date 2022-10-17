package com.YuXiuHui.modules.repair.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.repair.entity.RepairPicEntity;
import com.YuXiuHui.modules.repair.service.RepairPicService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;




/**
 * 报修图片
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("repairPic")
public class RepairPicController {
	@Autowired
	private RepairPicService repairPicService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RepairPicEntity> repairPicList = repairPicService.queryList(query);
		int total = repairPicService.queryTotal(query);
		
		return R.ok().put("rows", repairPicList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		RepairPicEntity repairPic = repairPicService.queryObject(id);
		
		return R.ok().put("repairPic", repairPic);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody RepairPicEntity repairPic){
		repairPicService.save(repairPic);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody RepairPicEntity repairPic){
		repairPicService.update(repairPic);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		repairPicService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
