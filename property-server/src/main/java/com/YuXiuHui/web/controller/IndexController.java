package com.YuXiuHui.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.YuXiuHui.common.annotation.AuthIgnore;

@Controller
@RequestMapping("/")
public class IndexController {
	
	/**
	 * 首页
	 */
	@AuthIgnore
	@RequestMapping("")
	public String index() throws Exception {
		return "admin/index.html";
	}
}
