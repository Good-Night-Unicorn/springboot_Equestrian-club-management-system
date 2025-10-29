package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebeiyudingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebeiyudingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeiyudingView;


/**
 * 设备预订
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface ShebeiyudingService extends IService<ShebeiyudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeiyudingVO> selectListVO(Wrapper<ShebeiyudingEntity> wrapper);
   	
   	ShebeiyudingVO selectVO(@Param("ew") Wrapper<ShebeiyudingEntity> wrapper);
   	
   	List<ShebeiyudingView> selectListView(Wrapper<ShebeiyudingEntity> wrapper);
   	
   	ShebeiyudingView selectView(@Param("ew") Wrapper<ShebeiyudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeiyudingEntity> wrapper);

   	

}

