package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KechengyudingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KechengyudingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KechengyudingView;


/**
 * 课程预订
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface KechengyudingService extends IService<KechengyudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengyudingVO> selectListVO(Wrapper<KechengyudingEntity> wrapper);
   	
   	KechengyudingVO selectVO(@Param("ew") Wrapper<KechengyudingEntity> wrapper);
   	
   	List<KechengyudingView> selectListView(Wrapper<KechengyudingEntity> wrapper);
   	
   	KechengyudingView selectView(@Param("ew") Wrapper<KechengyudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengyudingEntity> wrapper);

   	

}

