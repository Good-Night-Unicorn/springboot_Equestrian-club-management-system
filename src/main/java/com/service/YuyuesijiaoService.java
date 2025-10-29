package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyuesijiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyuesijiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyuesijiaoView;


/**
 * 预约私教
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public interface YuyuesijiaoService extends IService<YuyuesijiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuesijiaoVO> selectListVO(Wrapper<YuyuesijiaoEntity> wrapper);
   	
   	YuyuesijiaoVO selectVO(@Param("ew") Wrapper<YuyuesijiaoEntity> wrapper);
   	
   	List<YuyuesijiaoView> selectListView(Wrapper<YuyuesijiaoEntity> wrapper);
   	
   	YuyuesijiaoView selectView(@Param("ew") Wrapper<YuyuesijiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuesijiaoEntity> wrapper);

   	

}

