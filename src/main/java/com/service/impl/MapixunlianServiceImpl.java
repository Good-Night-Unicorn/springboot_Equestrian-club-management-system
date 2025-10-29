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


import com.dao.MapixunlianDao;
import com.entity.MapixunlianEntity;
import com.service.MapixunlianService;
import com.entity.vo.MapixunlianVO;
import com.entity.view.MapixunlianView;

@Service("mapixunlianService")
public class MapixunlianServiceImpl extends ServiceImpl<MapixunlianDao, MapixunlianEntity> implements MapixunlianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MapixunlianEntity> page = this.selectPage(
                new Query<MapixunlianEntity>(params).getPage(),
                new EntityWrapper<MapixunlianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MapixunlianEntity> wrapper) {
		  Page<MapixunlianView> page =new Query<MapixunlianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MapixunlianVO> selectListVO(Wrapper<MapixunlianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MapixunlianVO selectVO(Wrapper<MapixunlianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MapixunlianView> selectListView(Wrapper<MapixunlianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MapixunlianView selectView(Wrapper<MapixunlianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
