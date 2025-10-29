package com.dao;

import com.entity.YuyuesijiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyuesijiaoVO;
import com.entity.view.YuyuesijiaoView;


/**
 * 预约私教
 * 
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface YuyuesijiaoDao extends BaseMapper<YuyuesijiaoEntity> {
	
	List<YuyuesijiaoVO> selectListVO(@Param("ew") Wrapper<YuyuesijiaoEntity> wrapper);
	
	YuyuesijiaoVO selectVO(@Param("ew") Wrapper<YuyuesijiaoEntity> wrapper);
	
	List<YuyuesijiaoView> selectListView(@Param("ew") Wrapper<YuyuesijiaoEntity> wrapper);

	List<YuyuesijiaoView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuesijiaoEntity> wrapper);

	
	YuyuesijiaoView selectView(@Param("ew") Wrapper<YuyuesijiaoEntity> wrapper);
	

}
