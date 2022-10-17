package com.YuXiuHui.modules.goodsPay.controller;

import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.goodsPay.entity.GoodsPayEntity;
import com.YuXiuHui.modules.goodsPay.service.GoodsPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 用户
 * 
 * @author GDUFSlqm
 * 
 */
@RestController
@RequestMapping("/goodsPay")
public class GoodsPayController {
	
	@Autowired
	private GoodsPayService goodsPayService;
	
	@RequestMapping("/listAll")
	public R listAll(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<GoodsPayEntity> goodsPayList = goodsPayService.queryList(params);
		return R.ok().put("goodsPayList", goodsPayList);
	}
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsPayEntity> goodsPayList = goodsPayService.queryList(query);
		int total = goodsPayService.queryTotal(query);
		return R.ok().put("rows", goodsPayList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		GoodsPayEntity goodsPay = goodsPayService.queryObject(id);
		return R.ok().put("goodsPay", goodsPay);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestParam Map<String, Object> params){
		GoodsPayEntity goodsPay =new GoodsPayEntity();

		goodsPay.setGoodsId(Integer.valueOf((String) params.get("goodsId")));
		goodsPay.setMemberId(Integer.valueOf((String) params.get("memberId")));

		goodsPayService.save(goodsPay);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody GoodsPayEntity goodsPay){
		goodsPayService.update(goodsPay);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		goodsPayService.deleteBatch(ids);
		return R.ok();
	}
	
}
