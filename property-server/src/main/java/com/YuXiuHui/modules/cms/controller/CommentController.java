package com.YuXiuHui.modules.cms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.cms.entity.CommentEntity;
import com.YuXiuHui.modules.cms.service.CommentService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;

/**
 * 
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
@RestController
@RequestMapping("comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CommentEntity> commentList = commentService.queryList(query);
		int total = commentService.queryTotal(query);
		
		return R.ok().put("rows", commentList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		CommentEntity comment = commentService.queryObject(id);
		
		return R.ok().put("comment", comment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CommentEntity comment){
		commentService.save(comment);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CommentEntity comment){
		commentService.update(comment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		commentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
