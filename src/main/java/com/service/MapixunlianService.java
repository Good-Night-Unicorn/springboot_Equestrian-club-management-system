package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MapixunlianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MapixunlianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MapixunlianView;


/**
 * 马匹训练
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface MapixunlianService extends IService<MapixunlianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MapixunlianVO> selectListVO(Wrapper<MapixunlianEntity> wrapper);
   	
   	MapixunlianVO selectVO(@Param("ew") Wrapper<MapixunlianEntity> wrapper);
   	
   	List<MapixunlianView> selectListView(Wrapper<MapixunlianEntity> wrapper);
   	
   	MapixunlianView selectView(@Param("ew") Wrapper<MapixunlianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MapixunlianEntity> wrapper);

   	

}

