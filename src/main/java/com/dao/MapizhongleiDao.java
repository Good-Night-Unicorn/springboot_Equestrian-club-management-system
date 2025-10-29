package com.dao;

import com.entity.MapizhongleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MapizhongleiVO;
import com.entity.view.MapizhongleiView;


/**
 * 马匹种类
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface MapizhongleiDao extends BaseMapper<MapizhongleiEntity> {
	
	List<MapizhongleiVO> selectListVO(@Param("ew") Wrapper<MapizhongleiEntity> wrapper);
	
	MapizhongleiVO selectVO(@Param("ew") Wrapper<MapizhongleiEntity> wrapper);
	
	List<MapizhongleiView> selectListView(@Param("ew") Wrapper<MapizhongleiEntity> wrapper);

	List<MapizhongleiView> selectListView(Pagination page,@Param("ew") Wrapper<MapizhongleiEntity> wrapper);

	
	MapizhongleiView selectView(@Param("ew") Wrapper<MapizhongleiEntity> wrapper);
	

}
