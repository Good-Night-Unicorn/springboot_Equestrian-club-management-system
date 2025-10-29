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


import com.dao.ShebeiyudingDao;
import com.entity.ShebeiyudingEntity;
import com.service.ShebeiyudingService;
import com.entity.vo.ShebeiyudingVO;
import com.entity.view.ShebeiyudingView;

@Service("shebeiyudingService")
public class ShebeiyudingServiceImpl extends ServiceImpl<ShebeiyudingDao, ShebeiyudingEntity> implements ShebeiyudingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeiyudingEntity> page = this.selectPage(
                new Query<ShebeiyudingEntity>(params).getPage(),
                new EntityWrapper<ShebeiyudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeiyudingEntity> wrapper) {
		  Page<ShebeiyudingView> page =new Query<ShebeiyudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShebeiyudingVO> selectListVO(Wrapper<ShebeiyudingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeiyudingVO selectVO(Wrapper<ShebeiyudingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeiyudingView> selectListView(Wrapper<ShebeiyudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeiyudingView selectView(Wrapper<ShebeiyudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
