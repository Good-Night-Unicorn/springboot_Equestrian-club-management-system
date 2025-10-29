package com.dao;

import com.entity.DiscusssheshishebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusssheshishebeiVO;
import com.entity.view.DiscusssheshishebeiView;


/**
 * 设施设备评论表
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:19
 */
public interface DiscusssheshishebeiDao extends BaseMapper<DiscusssheshishebeiEntity> {
	
	List<DiscusssheshishebeiVO> selectListVO(@Param("ew") Wrapper<DiscusssheshishebeiEntity> wrapper);
	
	DiscusssheshishebeiVO selectVO(@Param("ew") Wrapper<DiscusssheshishebeiEntity> wrapper);
	
	List<DiscusssheshishebeiView> selectListView(@Param("ew") Wrapper<DiscusssheshishebeiEntity> wrapper);

	List<DiscusssheshishebeiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssheshishebeiEntity> wrapper);

	
	DiscusssheshishebeiView selectView(@Param("ew") Wrapper<DiscusssheshishebeiEntity> wrapper);
	

}
