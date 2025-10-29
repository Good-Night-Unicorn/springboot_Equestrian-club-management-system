package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SheshishebeiDao;
import com.entity.SheshishebeiEntity;
import com.service.SheshishebeiService;
import com.entity.vo.SheshishebeiVO;
import com.entity.view.SheshishebeiView;

@Service("sheshishebeiService")
public class SheshishebeiServiceImpl extends ServiceImpl<SheshishebeiDao, SheshishebeiEntity> implements SheshishebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SheshishebeiEntity> page = this.selectPage(
                new Query<SheshishebeiEntity>(params).getPage(),
                new EntityWrapper<SheshishebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SheshishebeiEntity> wrapper) {
		  Page<SheshishebeiView> page =new Query<SheshishebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<SheshishebeiVO> selectListVO(Wrapper<SheshishebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SheshishebeiVO selectVO(Wrapper<SheshishebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SheshishebeiView> selectListView(Wrapper<SheshishebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SheshishebeiView selectView(Wrapper<SheshishebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
