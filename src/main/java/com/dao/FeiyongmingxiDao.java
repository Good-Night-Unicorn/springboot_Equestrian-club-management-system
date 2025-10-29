package com.dao;

import com.entity.FeiyongmingxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FeiyongmingxiVO;
import com.entity.view.FeiyongmingxiView;


/**
 * 费用明细
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface FeiyongmingxiDao extends BaseMapper<FeiyongmingxiEntity> {
	
	List<FeiyongmingxiVO> selectListVO(@Param("ew") Wrapper<FeiyongmingxiEntity> wrapper);
	
	FeiyongmingxiVO selectVO(@Param("ew") Wrapper<FeiyongmingxiEntity> wrapper);
	
	List<FeiyongmingxiView> selectListView(@Param("ew") Wrapper<FeiyongmingxiEntity> wrapper);

	List<FeiyongmingxiView> selectListView(Pagination page,@Param("ew") Wrapper<FeiyongmingxiEntity> wrapper);

	
	FeiyongmingxiView selectView(@Param("ew") Wrapper<FeiyongmingxiEntity> wrapper);
	

}
