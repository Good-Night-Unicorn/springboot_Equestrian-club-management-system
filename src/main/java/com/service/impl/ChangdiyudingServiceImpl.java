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


import com.dao.ChangdiyudingDao;
import com.entity.ChangdiyudingEntity;
import com.service.ChangdiyudingService;
import com.entity.vo.ChangdiyudingVO;
import com.entity.view.ChangdiyudingView;

@Service("changdiyudingService")
public class ChangdiyudingServiceImpl extends ServiceImpl<ChangdiyudingDao, ChangdiyudingEntity> implements ChangdiyudingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangdiyudingEntity> page = this.selectPage(
                new Query<ChangdiyudingEntity>(params).getPage(),
                new EntityWrapper<ChangdiyudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangdiyudingEntity> wrapper) {
		  Page<ChangdiyudingView> page =new Query<ChangdiyudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChangdiyudingVO> selectListVO(Wrapper<ChangdiyudingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChangdiyudingVO selectVO(Wrapper<ChangdiyudingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChangdiyudingView> selectListView(Wrapper<ChangdiyudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChangdiyudingView selectView(Wrapper<ChangdiyudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
