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


import com.dao.MapizhongleiDao;
import com.entity.MapizhongleiEntity;
import com.service.MapizhongleiService;
import com.entity.vo.MapizhongleiVO;
import com.entity.view.MapizhongleiView;

@Service("mapizhongleiService")
public class MapizhongleiServiceImpl extends ServiceImpl<MapizhongleiDao, MapizhongleiEntity> implements MapizhongleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MapizhongleiEntity> page = this.selectPage(
                new Query<MapizhongleiEntity>(params).getPage(),
                new EntityWrapper<MapizhongleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MapizhongleiEntity> wrapper) {
		  Page<MapizhongleiView> page =new Query<MapizhongleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MapizhongleiVO> selectListVO(Wrapper<MapizhongleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MapizhongleiVO selectVO(Wrapper<MapizhongleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MapizhongleiView> selectListView(Wrapper<MapizhongleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MapizhongleiView selectView(Wrapper<MapizhongleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
