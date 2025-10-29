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


import com.dao.MapixinxiDao;
import com.entity.MapixinxiEntity;
import com.service.MapixinxiService;
import com.entity.vo.MapixinxiVO;
import com.entity.view.MapixinxiView;

@Service("mapixinxiService")
public class MapixinxiServiceImpl extends ServiceImpl<MapixinxiDao, MapixinxiEntity> implements MapixinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MapixinxiEntity> page = this.selectPage(
                new Query<MapixinxiEntity>(params).getPage(),
                new EntityWrapper<MapixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MapixinxiEntity> wrapper) {
		  Page<MapixinxiView> page =new Query<MapixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MapixinxiVO> selectListVO(Wrapper<MapixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MapixinxiVO selectVO(Wrapper<MapixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MapixinxiView> selectListView(Wrapper<MapixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MapixinxiView selectView(Wrapper<MapixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
