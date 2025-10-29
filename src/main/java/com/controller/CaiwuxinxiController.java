package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CaiwuxinxiEntity;
import com.entity.view.CaiwuxinxiView;

import com.service.CaiwuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 财务信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
@RestController
@RequestMapping("/caiwuxinxi")
public class CaiwuxinxiController {
    @Autowired
    private CaiwuxinxiService caiwuxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaiwuxinxiEntity caiwuxinxi,
		HttpServletRequest request){
        EntityWrapper<CaiwuxinxiEntity> ew = new EntityWrapper<CaiwuxinxiEntity>();



		PageUtils page = caiwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwuxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaiwuxinxiEntity caiwuxinxi, 
		HttpServletRequest request){
        EntityWrapper<CaiwuxinxiEntity> ew = new EntityWrapper<CaiwuxinxiEntity>();

		PageUtils page = caiwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caiwuxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaiwuxinxiEntity caiwuxinxi){
       	EntityWrapper<CaiwuxinxiEntity> ew = new EntityWrapper<CaiwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caiwuxinxi, "caiwuxinxi")); 
        return R.ok().put("data", caiwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaiwuxinxiEntity caiwuxinxi){
        EntityWrapper< CaiwuxinxiEntity> ew = new EntityWrapper< CaiwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caiwuxinxi, "caiwuxinxi")); 
		CaiwuxinxiView caiwuxinxiView =  caiwuxinxiService.selectView(ew);
		return R.ok("查询财务信息成功").put("data", caiwuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaiwuxinxiEntity caiwuxinxi = caiwuxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(caiwuxinxi,deSens);
        return R.ok().put("data", caiwuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaiwuxinxiEntity caiwuxinxi = caiwuxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(caiwuxinxi,deSens);
        return R.ok().put("data", caiwuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaiwuxinxiEntity caiwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caiwuxinxi);
        caiwuxinxiService.insert(caiwuxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaiwuxinxiEntity caiwuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caiwuxinxi);
        caiwuxinxiService.insert(caiwuxinxi);
        return R.ok().put("data",caiwuxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaiwuxinxiEntity caiwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caiwuxinxi);
        //全部更新
        caiwuxinxiService.updateById(caiwuxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caiwuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
