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


import com.dao.ShebeiyanghuDao;
import com.entity.ShebeiyanghuEntity;
import com.service.ShebeiyanghuService;
import com.entity.vo.ShebeiyanghuVO;
import com.entity.view.ShebeiyanghuView;

@Service("shebeiyanghuService")
public class ShebeiyanghuServiceImpl extends ServiceImpl<ShebeiyanghuDao, ShebeiyanghuEntity> implements ShebeiyanghuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeiyanghuEntity> page = this.selectPage(
                new Query<ShebeiyanghuEntity>(params).getPage(),
                new EntityWrapper<ShebeiyanghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeiyanghuEntity> wrapper) {
		  Page<ShebeiyanghuView> page =new Query<ShebeiyanghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShebeiyanghuVO> selectListVO(Wrapper<ShebeiyanghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeiyanghuVO selectVO(Wrapper<ShebeiyanghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeiyanghuView> selectListView(Wrapper<ShebeiyanghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeiyanghuView selectView(Wrapper<ShebeiyanghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
