package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MapizhongleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MapizhongleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MapizhongleiView;


/**
 * 马匹种类
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface MapizhongleiService extends IService<MapizhongleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MapizhongleiVO> selectListVO(Wrapper<MapizhongleiEntity> wrapper);
   	
   	MapizhongleiVO selectVO(@Param("ew") Wrapper<MapizhongleiEntity> wrapper);
   	
   	List<MapizhongleiView> selectListView(Wrapper<MapizhongleiEntity> wrapper);
   	
   	MapizhongleiView selectView(@Param("ew") Wrapper<MapizhongleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MapizhongleiEntity> wrapper);

   	

}

