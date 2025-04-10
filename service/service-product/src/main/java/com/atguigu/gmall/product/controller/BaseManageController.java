package com.atguigu.gmall.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.ManagerService;

import io.swagger.annotations.Api;

@Api(tags = "商品基础属性接口")
@RestController
@RequestMapping("admin/product")
//@CrossOrigin
public class BaseManageController {

	@Autowired
	private ManagerService managerService;

	/**
	 * 保存平台属性方法
	 * 
	 * @param baseAttrInfo
	 * @return
	 */
	@PostMapping("saveAttrInfo")
	public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {
		// 前台数据都被封装到该对象中baseAttrInfo
		managerService.saveAttrInfo(baseAttrInfo);
		return Result.ok();
	}

	@GetMapping("getAttrValueList/{attrId}")
	public Result<List<BaseAttrValue>> getAttrValueList(@PathVariable("attrId") Long attrId) {
		BaseAttrInfo baseAttrInfo = managerService.getAttrInfo(attrId);
		List<BaseAttrValue> baseAttrValueList = baseAttrInfo.getAttrValueList();
		return Result.ok(baseAttrValueList);
	}

	/**
	 * 查询所有的一级分类信息
	 * 
	 * @return
	 */
	@GetMapping("getCategory1")
	public Result<List<BaseCategory1>> getCategory1() {
		List<BaseCategory1> baseCategory1List = managerService.getCategory1();
		return Result.ok(baseCategory1List);
	}

	/**
	 * 根据一级分类Id 查询二级分类数据
	 * 
	 * @param category1Id
	 * @return
	 */
	@GetMapping("getCategory2/{category1Id}")
	public Result<List<BaseCategory2>> getCategory2(@PathVariable("category1Id") Long category1Id) {
		List<BaseCategory2> baseCategory2List = managerService.getCategory2(category1Id);
		return Result.ok(baseCategory2List);
	}

	/**
	 * 根据二级分类Id 查询三级分类数据
	 * 
	 * @param category2Id
	 * @return
	 */
	@GetMapping("getCategory3/{category2Id}")
	public Result<List<BaseCategory3>> getCategory3(@PathVariable("category2Id") Long category2Id) {
		List<BaseCategory3> baseCategory3List = managerService.getCategory3(category2Id);
		return Result.ok(baseCategory3List);
	}

	/**
	 * 根据分类Id 获取平台属性数据
	 * 
	 * @param category1Id
	 * @param category2Id
	 * @param category3Id
	 * @return
	 */
	@GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
	public Result<List<BaseAttrInfo>> attrInfoList(@PathVariable("category1Id") Long category1Id,
			@PathVariable("category2Id") Long category2Id, @PathVariable("category3Id") Long category3Id) {
		List<BaseAttrInfo> baseAttrInfoList = managerService.attrInfoList(category1Id, category2Id, category3Id);
		return Result.ok(baseAttrInfoList);
	}
}
