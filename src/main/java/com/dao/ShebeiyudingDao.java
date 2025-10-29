package com.dao;

import com.entity.ShebeiyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeiyudingVO;
import com.entity.view.ShebeiyudingView;


/**
 * 设备预订
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface ShebeiyudingDao extends BaseMapper<ShebeiyudingEntity> {
	
	List<ShebeiyudingVO> selectListVO(@Param("ew") Wrapper<ShebeiyudingEntity> wrapper);
	
	ShebeiyudingVO selectVO(@Param("ew") Wrapper<ShebeiyudingEntity> wrapper);
	
	List<ShebeiyudingView> selectListView(@Param("ew") Wrapper<ShebeiyudingEntity> wrapper);

	List<ShebeiyudingView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeiyudingEntity> wrapper);

	
	ShebeiyudingView selectView(@Param("ew") Wrapper<ShebeiyudingEntity> wrapper);
	

}
