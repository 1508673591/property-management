package com.YuXiuHui.modules.cms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.cms.entity.ColumnEntity;
import com.YuXiuHui.modules.cms.service.ColumnService;


/**
 * 栏目
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
@RestController
@RequestMapping("column")
public class ColumnController{
	@Autowired
	private ColumnService columnService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public List<ColumnEntity> list(@RequestParam Map<String, Object> params){
		//查询列表数据
		params.put("sidx", "sort");
		params.put("order", "asc");
		List<ColumnEntity> columnList = columnService.queryList(params);
		return columnList;
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ColumnEntity column = columnService.queryObject(id);
		
		return R.ok().put("column", column);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ColumnEntity column){
		columnService.save(column);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ColumnEntity column){
		columnService.update(column);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(Integer id){
		if(id == null) {
			return R.error("请选择删除栏目");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentId", id);
		List<ColumnEntity> columnList = columnService.queryList(params);
		if(columnList.size() > 0){
			return R.error("请先删除子栏目");
		}
		columnService.deleteBatch(new Integer[]{id});
		
		return R.ok();
	}
	
}
