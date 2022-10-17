package com.YuXiuHui.modules.property.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.property.entity.PayEntity;
import com.YuXiuHui.modules.property.service.PayService;

@RestController
@RequestMapping("/api/pay")
public class ApiPayController {
	
	@Autowired
	private PayService payService;

	@RequestMapping("/list")
	public R list(@RequestAttribute Long userId, @RequestParam Map<String, Object> params) {
		params.put("memberId", userId);
		List<PayEntity> payList = payService.queryList(params);
		return R.ok().put("payList", payList);
	}
	
	@RequestMapping("/save")
	public R save(@RequestAttribute Long userId, @RequestBody PayEntity pay){
		pay.setMemberId(userId);
		pay.setCreateTime(new Date());
		payService.save(pay);
		
		return R.ok();
	}
}
