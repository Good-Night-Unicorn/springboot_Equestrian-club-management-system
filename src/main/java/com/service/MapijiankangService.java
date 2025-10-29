package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MapijiankangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MapijiankangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MapijiankangView;


/**
 * 马匹健康
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface MapijiankangService extends IService<MapijiankangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MapijiankangVO> selectListVO(Wrapper<MapijiankangEntity> wrapper);
   	
   	MapijiankangVO selectVO(@Param("ew") Wrapper<MapijiankangEntity> wrapper);
   	
   	List<MapijiankangView> selectListView(Wrapper<MapijiankangEntity> wrapper);
   	
   	MapijiankangView selectView(@Param("ew") Wrapper<MapijiankangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MapijiankangEntity> wrapper);

   	

}

