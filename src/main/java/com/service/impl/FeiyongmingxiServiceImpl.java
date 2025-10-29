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


import com.dao.FeiyongmingxiDao;
import com.entity.FeiyongmingxiEntity;
import com.service.FeiyongmingxiService;
import com.entity.vo.FeiyongmingxiVO;
import com.entity.view.FeiyongmingxiView;

@Service("feiyongmingxiService")
public class FeiyongmingxiServiceImpl extends ServiceImpl<FeiyongmingxiDao, FeiyongmingxiEntity> implements FeiyongmingxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FeiyongmingxiEntity> page = this.selectPage(
                new Query<FeiyongmingxiEntity>(params).getPage(),
                new EntityWrapper<FeiyongmingxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FeiyongmingxiEntity> wrapper) {
		  Page<FeiyongmingxiView> page =new Query<FeiyongmingxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FeiyongmingxiVO> selectListVO(Wrapper<FeiyongmingxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FeiyongmingxiVO selectVO(Wrapper<FeiyongmingxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FeiyongmingxiView> selectListView(Wrapper<FeiyongmingxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FeiyongmingxiView selectView(Wrapper<FeiyongmingxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
