package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FeiyongmingxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FeiyongmingxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FeiyongmingxiView;


/**
 * 费用明细
 *
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public interface FeiyongmingxiService extends IService<FeiyongmingxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FeiyongmingxiVO> selectListVO(Wrapper<FeiyongmingxiEntity> wrapper);
   	
   	FeiyongmingxiVO selectVO(@Param("ew") Wrapper<FeiyongmingxiEntity> wrapper);
   	
   	List<FeiyongmingxiView> selectListView(Wrapper<FeiyongmingxiEntity> wrapper);
   	
   	FeiyongmingxiView selectView(@Param("ew") Wrapper<FeiyongmingxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FeiyongmingxiEntity> wrapper);

   	

}

