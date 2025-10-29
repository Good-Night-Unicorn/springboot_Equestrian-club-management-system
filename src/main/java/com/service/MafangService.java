package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MafangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MafangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MafangView;


/**
 * 马房管理员
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:14
 */
public interface MafangService extends IService<MafangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MafangVO> selectListVO(Wrapper<MafangEntity> wrapper);
   	
   	MafangVO selectVO(@Param("ew") Wrapper<MafangEntity> wrapper);
   	
   	List<MafangView> selectListView(Wrapper<MafangEntity> wrapper);
   	
   	MafangView selectView(@Param("ew") Wrapper<MafangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MafangEntity> wrapper);

   	

}

