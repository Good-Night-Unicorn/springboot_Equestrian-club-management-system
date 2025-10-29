package com.dao;

import com.entity.MapixunlianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MapixunlianVO;
import com.entity.view.MapixunlianView;


/**
 * 马匹训练
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface MapixunlianDao extends BaseMapper<MapixunlianEntity> {
	
	List<MapixunlianVO> selectListVO(@Param("ew") Wrapper<MapixunlianEntity> wrapper);
	
	MapixunlianVO selectVO(@Param("ew") Wrapper<MapixunlianEntity> wrapper);
	
	List<MapixunlianView> selectListView(@Param("ew") Wrapper<MapixunlianEntity> wrapper);

	List<MapixunlianView> selectListView(Pagination page,@Param("ew") Wrapper<MapixunlianEntity> wrapper);

	
	MapixunlianView selectView(@Param("ew") Wrapper<MapixunlianEntity> wrapper);
	

}
