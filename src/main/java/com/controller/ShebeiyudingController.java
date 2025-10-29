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

import com.entity.ShebeiyudingEntity;
import com.entity.view.ShebeiyudingView;

import com.service.ShebeiyudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备预订
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/shebeiyuding")
public class ShebeiyudingController {
    @Autowired
    private ShebeiyudingService shebeiyudingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeiyudingEntity shebeiyuding,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            shebeiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ShebeiyudingEntity> ew = new EntityWrapper<ShebeiyudingEntity>();



		PageUtils page = shebeiyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiyuding), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeiyudingEntity shebeiyuding, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		shebeiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<ShebeiyudingEntity> ew = new EntityWrapper<ShebeiyudingEntity>();

		PageUtils page = shebeiyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiyuding), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeiyudingEntity shebeiyuding){
       	EntityWrapper<ShebeiyudingEntity> ew = new EntityWrapper<ShebeiyudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeiyuding, "shebeiyuding")); 
        return R.ok().put("data", shebeiyudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeiyudingEntity shebeiyuding){
        EntityWrapper< ShebeiyudingEntity> ew = new EntityWrapper< ShebeiyudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeiyuding, "shebeiyuding")); 
		ShebeiyudingView shebeiyudingView =  shebeiyudingService.selectView(ew);
		return R.ok("查询设备预订成功").put("data", shebeiyudingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeiyudingEntity shebeiyuding = shebeiyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebeiyuding,deSens);
        return R.ok().put("data", shebeiyuding);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeiyudingEntity shebeiyuding = shebeiyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebeiyuding,deSens);
        return R.ok().put("data", shebeiyuding);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeiyudingEntity shebeiyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebeiyuding);
    	shebeiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
        shebeiyudingService.insert(shebeiyuding);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeiyudingEntity shebeiyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebeiyuding);
    	shebeiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
        shebeiyudingService.insert(shebeiyuding);
        return R.ok().put("data",shebeiyuding.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShebeiyudingEntity shebeiyuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeiyuding);
        //全部更新
        shebeiyudingService.updateById(shebeiyuding);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shebeiyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
