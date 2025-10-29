package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheshishebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SheshishebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SheshishebeiView;


/**
 * 设施设备
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface SheshishebeiService extends IService<SheshishebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SheshishebeiVO> selectListVO(Wrapper<SheshishebeiEntity> wrapper);
   	
   	SheshishebeiVO selectVO(@Param("ew") Wrapper<SheshishebeiEntity> wrapper);
   	
   	List<SheshishebeiView> selectListView(Wrapper<SheshishebeiEntity> wrapper);
   	
   	SheshishebeiView selectView(@Param("ew") Wrapper<SheshishebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SheshishebeiEntity> wrapper);

   	

}

