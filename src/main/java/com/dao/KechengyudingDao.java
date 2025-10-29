package com.dao;

import com.entity.KechengyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KechengyudingVO;
import com.entity.view.KechengyudingView;


/**
 * 课程预订
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface KechengyudingDao extends BaseMapper<KechengyudingEntity> {
	
	List<KechengyudingVO> selectListVO(@Param("ew") Wrapper<KechengyudingEntity> wrapper);
	
	KechengyudingVO selectVO(@Param("ew") Wrapper<KechengyudingEntity> wrapper);
	
	List<KechengyudingView> selectListView(@Param("ew") Wrapper<KechengyudingEntity> wrapper);

	List<KechengyudingView> selectListView(Pagination page,@Param("ew") Wrapper<KechengyudingEntity> wrapper);

	
	KechengyudingView selectView(@Param("ew") Wrapper<KechengyudingEntity> wrapper);
	

}
