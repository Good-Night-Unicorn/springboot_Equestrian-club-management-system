package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusssheshishebeiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusssheshishebeiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusssheshishebeiView;


/**
 * 设施设备评论表
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:19
 */
public interface DiscusssheshishebeiService extends IService<DiscusssheshishebeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssheshishebeiVO> selectListVO(Wrapper<DiscusssheshishebeiEntity> wrapper);
   	
   	DiscusssheshishebeiVO selectVO(@Param("ew") Wrapper<DiscusssheshishebeiEntity> wrapper);
   	
   	List<DiscusssheshishebeiView> selectListView(Wrapper<DiscusssheshishebeiEntity> wrapper);
   	
   	DiscusssheshishebeiView selectView(@Param("ew") Wrapper<DiscusssheshishebeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssheshishebeiEntity> wrapper);

   	

}

