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


import com.dao.ChangdiyanghuDao;
import com.entity.ChangdiyanghuEntity;
import com.service.ChangdiyanghuService;
import com.entity.vo.ChangdiyanghuVO;
import com.entity.view.ChangdiyanghuView;

@Service("changdiyanghuService")
public class ChangdiyanghuServiceImpl extends ServiceImpl<ChangdiyanghuDao, ChangdiyanghuEntity> implements ChangdiyanghuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangdiyanghuEntity> page = this.selectPage(
                new Query<ChangdiyanghuEntity>(params).getPage(),
                new EntityWrapper<ChangdiyanghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangdiyanghuEntity> wrapper) {
		  Page<ChangdiyanghuView> page =new Query<ChangdiyanghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChangdiyanghuVO> selectListVO(Wrapper<ChangdiyanghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChangdiyanghuVO selectVO(Wrapper<ChangdiyanghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChangdiyanghuView> selectListView(Wrapper<ChangdiyanghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChangdiyanghuView selectView(Wrapper<ChangdiyanghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
