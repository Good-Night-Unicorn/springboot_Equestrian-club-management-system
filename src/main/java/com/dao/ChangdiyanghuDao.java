package com.dao;

import com.entity.ChangdiyanghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChangdiyanghuVO;
import com.entity.view.ChangdiyanghuView;


/**
 * 场地养护
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface ChangdiyanghuDao extends BaseMapper<ChangdiyanghuEntity> {
	
	List<ChangdiyanghuVO> selectListVO(@Param("ew") Wrapper<ChangdiyanghuEntity> wrapper);
	
	ChangdiyanghuVO selectVO(@Param("ew") Wrapper<ChangdiyanghuEntity> wrapper);
	
	List<ChangdiyanghuView> selectListView(@Param("ew") Wrapper<ChangdiyanghuEntity> wrapper);

	List<ChangdiyanghuView> selectListView(Pagination page,@Param("ew") Wrapper<ChangdiyanghuEntity> wrapper);

	
	ChangdiyanghuView selectView(@Param("ew") Wrapper<ChangdiyanghuEntity> wrapper);
	

}
