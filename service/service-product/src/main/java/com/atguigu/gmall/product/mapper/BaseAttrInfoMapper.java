package com.atguigu.gmall.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {
	/**
	 * 根据分类Id 查询平台属性集合对象 | 编写xml 文件
	 * 
	 * @param category1Id
	 * @param category2Id
	 * @param category3Id
	 * @return
	 */
	List<BaseAttrInfo> selectAttrInfoList(@Param("category1Id") Long category1Id,
			@Param("category2Id") Long category2Id, @Param("category3Id") Long category3Id);

}
