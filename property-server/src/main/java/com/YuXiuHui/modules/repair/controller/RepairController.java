package com.YuXiuHui.modules.repair.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.repair.entity.RepairEntity;
import com.YuXiuHui.modules.repair.service.RepairService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;




/**
 * 报修
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("repair")
public class RepairController {
	@Autowired
	private RepairService repairService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RepairEntity> repairList = repairService.queryList(query);
		int total = repairService.queryTotal(query);
		
		return R.ok().put("rows", repairList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		RepairEntity repair = repairService.queryObject(id);
		
		return R.ok().put("repair", repair);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody RepairEntity repair){
		repairService.save(repair);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody RepairEntity repair){
		repairService.update(repair);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		repairService.deleteBatch(ids);
		
		return R.ok();
	}
	
	@RequestMapping("/complete")
	public R complete(@RequestBody Integer[] ids){
		repairService.complete(ids);
		
		return R.ok();
	}
}
