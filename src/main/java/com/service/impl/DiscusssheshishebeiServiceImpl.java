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


import com.dao.DiscusssheshishebeiDao;
import com.entity.DiscusssheshishebeiEntity;
import com.service.DiscusssheshishebeiService;
import com.entity.vo.DiscusssheshishebeiVO;
import com.entity.view.DiscusssheshishebeiView;

@Service("discusssheshishebeiService")
public class DiscusssheshishebeiServiceImpl extends ServiceImpl<DiscusssheshishebeiDao, DiscusssheshishebeiEntity> implements DiscusssheshishebeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssheshishebeiEntity> page = this.selectPage(
                new Query<DiscusssheshishebeiEntity>(params).getPage(),
                new EntityWrapper<DiscusssheshishebeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssheshishebeiEntity> wrapper) {
		  Page<DiscusssheshishebeiView> page =new Query<DiscusssheshishebeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusssheshishebeiVO> selectListVO(Wrapper<DiscusssheshishebeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusssheshishebeiVO selectVO(Wrapper<DiscusssheshishebeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusssheshishebeiView> selectListView(Wrapper<DiscusssheshishebeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssheshishebeiView selectView(Wrapper<DiscusssheshishebeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
