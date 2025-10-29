package com.dao;

import com.entity.MapixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MapixinxiVO;
import com.entity.view.MapixinxiView;


/**
 * 马匹信息
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface MapixinxiDao extends BaseMapper<MapixinxiEntity> {
	
	List<MapixinxiVO> selectListVO(@Param("ew") Wrapper<MapixinxiEntity> wrapper);
	
	MapixinxiVO selectVO(@Param("ew") Wrapper<MapixinxiEntity> wrapper);
	
	List<MapixinxiView> selectListView(@Param("ew") Wrapper<MapixinxiEntity> wrapper);

	List<MapixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<MapixinxiEntity> wrapper);

	
	MapixinxiView selectView(@Param("ew") Wrapper<MapixinxiEntity> wrapper);
	

}
