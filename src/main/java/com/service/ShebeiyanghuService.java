package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebeiyanghuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebeiyanghuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeiyanghuView;


/**
 * 设备养护
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface ShebeiyanghuService extends IService<ShebeiyanghuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeiyanghuVO> selectListVO(Wrapper<ShebeiyanghuEntity> wrapper);
   	
   	ShebeiyanghuVO selectVO(@Param("ew") Wrapper<ShebeiyanghuEntity> wrapper);
   	
   	List<ShebeiyanghuView> selectListView(Wrapper<ShebeiyanghuEntity> wrapper);
   	
   	ShebeiyanghuView selectView(@Param("ew") Wrapper<ShebeiyanghuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeiyanghuEntity> wrapper);

   	

}

