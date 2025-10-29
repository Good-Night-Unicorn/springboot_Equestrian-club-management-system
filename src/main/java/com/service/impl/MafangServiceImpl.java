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


import com.dao.MafangDao;
import com.entity.MafangEntity;
import com.service.MafangService;
import com.entity.vo.MafangVO;
import com.entity.view.MafangView;

@Service("mafangService")
public class MafangServiceImpl extends ServiceImpl<MafangDao, MafangEntity> implements MafangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MafangEntity> page = this.selectPage(
                new Query<MafangEntity>(params).getPage(),
                new EntityWrapper<MafangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MafangEntity> wrapper) {
		  Page<MafangView> page =new Query<MafangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MafangVO> selectListVO(Wrapper<MafangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MafangVO selectVO(Wrapper<MafangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MafangView> selectListView(Wrapper<MafangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MafangView selectView(Wrapper<MafangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
