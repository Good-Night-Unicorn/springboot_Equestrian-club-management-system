package com.dao;

import com.entity.MapijiankangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MapijiankangVO;
import com.entity.view.MapijiankangView;


/**
 * 马匹健康
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface MapijiankangDao extends BaseMapper<MapijiankangEntity> {
	
	List<MapijiankangVO> selectListVO(@Param("ew") Wrapper<MapijiankangEntity> wrapper);
	
	MapijiankangVO selectVO(@Param("ew") Wrapper<MapijiankangEntity> wrapper);
	
	List<MapijiankangView> selectListView(@Param("ew") Wrapper<MapijiankangEntity> wrapper);

	List<MapijiankangView> selectListView(Pagination page,@Param("ew") Wrapper<MapijiankangEntity> wrapper);

	
	MapijiankangView selectView(@Param("ew") Wrapper<MapijiankangEntity> wrapper);
	

}
