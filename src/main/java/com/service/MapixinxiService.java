package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MapixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MapixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MapixinxiView;


/**
 * 马匹信息
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface MapixinxiService extends IService<MapixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MapixinxiVO> selectListVO(Wrapper<MapixinxiEntity> wrapper);
   	
   	MapixinxiVO selectVO(@Param("ew") Wrapper<MapixinxiEntity> wrapper);
   	
   	List<MapixinxiView> selectListView(Wrapper<MapixinxiEntity> wrapper);
   	
   	MapixinxiView selectView(@Param("ew") Wrapper<MapixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MapixinxiEntity> wrapper);

   	

}

