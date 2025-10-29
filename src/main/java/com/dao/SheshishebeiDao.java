package com.dao;

import com.entity.SheshishebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheshishebeiVO;
import com.entity.view.SheshishebeiView;


/**
 * 设施设备
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface SheshishebeiDao extends BaseMapper<SheshishebeiEntity> {
	
	List<SheshishebeiVO> selectListVO(@Param("ew") Wrapper<SheshishebeiEntity> wrapper);
	
	SheshishebeiVO selectVO(@Param("ew") Wrapper<SheshishebeiEntity> wrapper);
	
	List<SheshishebeiView> selectListView(@Param("ew") Wrapper<SheshishebeiEntity> wrapper);

	List<SheshishebeiView> selectListView(Pagination page,@Param("ew") Wrapper<SheshishebeiEntity> wrapper);

	
	SheshishebeiView selectView(@Param("ew") Wrapper<SheshishebeiEntity> wrapper);
	

}
