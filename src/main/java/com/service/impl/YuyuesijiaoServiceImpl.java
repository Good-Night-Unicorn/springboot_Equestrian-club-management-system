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


import com.dao.YuyuesijiaoDao;
import com.entity.YuyuesijiaoEntity;
import com.service.YuyuesijiaoService;
import com.entity.vo.YuyuesijiaoVO;
import com.entity.view.YuyuesijiaoView;

@Service("yuyuesijiaoService")
public class YuyuesijiaoServiceImpl extends ServiceImpl<YuyuesijiaoDao, YuyuesijiaoEntity> implements YuyuesijiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuesijiaoEntity> page = this.selectPage(
                new Query<YuyuesijiaoEntity>(params).getPage(),
                new EntityWrapper<YuyuesijiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuesijiaoEntity> wrapper) {
		  Page<YuyuesijiaoView> page =new Query<YuyuesijiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuyuesijiaoVO> selectListVO(Wrapper<YuyuesijiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuyuesijiaoVO selectVO(Wrapper<YuyuesijiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuyuesijiaoView> selectListView(Wrapper<YuyuesijiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuesijiaoView selectView(Wrapper<YuyuesijiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
