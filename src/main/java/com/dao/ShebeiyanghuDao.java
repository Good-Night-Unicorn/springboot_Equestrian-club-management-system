package com.dao;

import com.entity.ShebeiyanghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeiyanghuVO;
import com.entity.view.ShebeiyanghuView;


/**
 * 设备养护
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface ShebeiyanghuDao extends BaseMapper<ShebeiyanghuEntity> {
	
	List<ShebeiyanghuVO> selectListVO(@Param("ew") Wrapper<ShebeiyanghuEntity> wrapper);
	
	ShebeiyanghuVO selectVO(@Param("ew") Wrapper<ShebeiyanghuEntity> wrapper);
	
	List<ShebeiyanghuView> selectListView(@Param("ew") Wrapper<ShebeiyanghuEntity> wrapper);

	List<ShebeiyanghuView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeiyanghuEntity> wrapper);

	
	ShebeiyanghuView selectView(@Param("ew") Wrapper<ShebeiyanghuEntity> wrapper);
	

}
