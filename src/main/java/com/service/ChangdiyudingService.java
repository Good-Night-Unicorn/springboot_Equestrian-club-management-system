package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangdiyudingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangdiyudingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangdiyudingView;


/**
 * 场地预订
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface ChangdiyudingService extends IService<ChangdiyudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangdiyudingVO> selectListVO(Wrapper<ChangdiyudingEntity> wrapper);
   	
   	ChangdiyudingVO selectVO(@Param("ew") Wrapper<ChangdiyudingEntity> wrapper);
   	
   	List<ChangdiyudingView> selectListView(Wrapper<ChangdiyudingEntity> wrapper);
   	
   	ChangdiyudingView selectView(@Param("ew") Wrapper<ChangdiyudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangdiyudingEntity> wrapper);

   	

}

