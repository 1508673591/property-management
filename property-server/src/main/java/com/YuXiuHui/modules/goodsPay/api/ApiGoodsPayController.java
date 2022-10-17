package com.YuXiuHui.modules.goodsPay.api;

import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.goodsPay.entity.GoodsPayEntity;
import com.YuXiuHui.modules.goodsPay.service.GoodsPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 * @author GDUFSlqm
 *
 */
@RestController
@RequestMapping("/api/goodsPay")
public class ApiGoodsPayController {
	
	@Autowired
	private GoodsPayService goodsPayService;
	
	/**
	 * 用户详情
	 * @param userId
	 * @return
	 */
    @GetMapping("info")
    public R info(@RequestAttribute Long userId){
    	GoodsPayEntity goodsPay = goodsPayService.queryObject(userId);
        return R.ok().put("goodsPay", goodsPay);
    }
	
	/**
	 * 更新用户
	 * @param goodsPay
	 * @return
	 */
	@RequestMapping("/update")
	public R update(@RequestBody GoodsPayEntity goodsPay){
		goodsPayService.update(goodsPay);
		return R.ok();
	}
}
