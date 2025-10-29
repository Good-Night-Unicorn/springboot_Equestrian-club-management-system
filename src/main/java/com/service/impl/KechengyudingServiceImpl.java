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


import com.dao.KechengyudingDao;
import com.entity.KechengyudingEntity;
import com.service.KechengyudingService;
import com.entity.vo.KechengyudingVO;
import com.entity.view.KechengyudingView;

@Service("kechengyudingService")
public class KechengyudingServiceImpl extends ServiceImpl<KechengyudingDao, KechengyudingEntity> implements KechengyudingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengyudingEntity> page = this.selectPage(
                new Query<KechengyudingEntity>(params).getPage(),
                new EntityWrapper<KechengyudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengyudingEntity> wrapper) {
		  Page<KechengyudingView> page =new Query<KechengyudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KechengyudingVO> selectListVO(Wrapper<KechengyudingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KechengyudingVO selectVO(Wrapper<KechengyudingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KechengyudingView> selectListView(Wrapper<KechengyudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengyudingView selectView(Wrapper<KechengyudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
