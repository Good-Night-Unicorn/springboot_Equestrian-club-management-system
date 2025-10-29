package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangdiyanghuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangdiyanghuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangdiyanghuView;


/**
 * 场地养护
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface ChangdiyanghuService extends IService<ChangdiyanghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangdiyanghuVO> selectListVO(Wrapper<ChangdiyanghuEntity> wrapper);
   	
   	ChangdiyanghuVO selectVO(@Param("ew") Wrapper<ChangdiyanghuEntity> wrapper);
   	
   	List<ChangdiyanghuView> selectListView(Wrapper<ChangdiyanghuEntity> wrapper);
   	
   	ChangdiyanghuView selectView(@Param("ew") Wrapper<ChangdiyanghuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangdiyanghuEntity> wrapper);

   	

}

