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


import com.dao.MapijiankangDao;
import com.entity.MapijiankangEntity;
import com.service.MapijiankangService;
import com.entity.vo.MapijiankangVO;
import com.entity.view.MapijiankangView;

@Service("mapijiankangService")
public class MapijiankangServiceImpl extends ServiceImpl<MapijiankangDao, MapijiankangEntity> implements MapijiankangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MapijiankangEntity> page = this.selectPage(
                new Query<MapijiankangEntity>(params).getPage(),
                new EntityWrapper<MapijiankangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MapijiankangEntity> wrapper) {
		  Page<MapijiankangView> page =new Query<MapijiankangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MapijiankangVO> selectListVO(Wrapper<MapijiankangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MapijiankangVO selectVO(Wrapper<MapijiankangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MapijiankangView> selectListView(Wrapper<MapijiankangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MapijiankangView selectView(Wrapper<MapijiankangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
