package com.YuXiuHui.modules.cms.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.cms.entity.ArticleEntity;
import com.YuXiuHui.modules.cms.service.ArticleService;
import com.YuXiuHui.modules.cms.service.CommentService;
import com.YuXiuHui.modules.member.service.MemberService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;

/**
 * 
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
@RestController
@RequestMapping("article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CommentService commentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ArticleEntity> articleList = articleService.queryList(query);
		int total = articleService.queryTotal(query);
		
		return R.ok().put("rows", articleList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ArticleEntity article = articleService.queryObject(id);
		
		return R.ok().put("article", article);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ArticleEntity article){
		article.setPublishDate(new Date());
		articleService.save(article);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ArticleEntity article){
		articleService.update(article);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		articleService.deleteBatch(ids);
		
		return R.ok();
	}
	
	/**
	 * 统计
	 * @param params
	 * @return
	 */
	@RequestMapping("/statistics")
	public R statistics(@RequestParam Map<String, Object> params) {
		Integer articleTotal = articleService.queryTotal(params);
		Integer memberTotal = memberService.queryTotal(params);
		Integer commentTotal = commentService.queryTotal(params);
		
		return R.ok().put("articleTotal", articleTotal).put("memberTotal", memberTotal).put("commentTotal", commentTotal);
	}
}
