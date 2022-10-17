package com.YuXiuHui.modules.house.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.house.entity.BuildingEntity;
import com.YuXiuHui.modules.house.service.BuildingService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;




/**
 * 楼宇
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("building")
public class BuildingController {
	@Autowired
	private BuildingService buildingService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/listAll")
	public R listAll(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<BuildingEntity> buildingList = buildingService.queryList(params);
		
		return R.ok().put("buildingList", buildingList);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BuildingEntity> buildingList = buildingService.queryList(query);
		int total = buildingService.queryTotal(query);
		
		return R.ok().put("rows", buildingList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		BuildingEntity building = buildingService.queryObject(id);
		
		return R.ok().put("building", building);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody BuildingEntity building){
		building.setCreateTime(new Date());
		buildingService.save(building);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody BuildingEntity building){
		buildingService.update(building);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		buildingService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
