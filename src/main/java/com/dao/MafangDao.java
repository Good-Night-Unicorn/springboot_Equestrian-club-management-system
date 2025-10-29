package com.dao;

import com.entity.MafangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MafangVO;
import com.entity.view.MafangView;


/**
 * 马房管理员
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:14
 */
public interface MafangDao extends BaseMapper<MafangEntity> {
	
	List<MafangVO> selectListVO(@Param("ew") Wrapper<MafangEntity> wrapper);
	
	MafangVO selectVO(@Param("ew") Wrapper<MafangEntity> wrapper);
	
	List<MafangView> selectListView(@Param("ew") Wrapper<MafangEntity> wrapper);

	List<MafangView> selectListView(Pagination page,@Param("ew") Wrapper<MafangEntity> wrapper);

	
	MafangView selectView(@Param("ew") Wrapper<MafangEntity> wrapper);
	

}
