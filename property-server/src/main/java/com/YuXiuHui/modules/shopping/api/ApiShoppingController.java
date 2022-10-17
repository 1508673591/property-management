package com.YuXiuHui.modules.shopping.api;

import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.shopping.entity.ShoppingEntity;
import com.YuXiuHui.modules.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shopping")
public class ApiShoppingController {
	
	@Autowired
	private ShoppingService shoppingService;

	@RequestMapping("/list")
	public R list(@RequestAttribute Long userId, @RequestParam Map<String, Object> params) {
		params.put("memberId", userId);
		List<ShoppingEntity> shoppingList = shoppingService.queryList(params);
		return R.ok().put("shoppingList", shoppingList);
	}
	
	
}
