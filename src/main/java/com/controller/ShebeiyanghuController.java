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

import com.entity.ShebeiyanghuEntity;
import com.entity.view.ShebeiyanghuView;

import com.service.ShebeiyanghuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备养护
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/shebeiyanghu")
public class ShebeiyanghuController {
    @Autowired
    private ShebeiyanghuService shebeiyanghuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeiyanghuEntity shebeiyanghu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("mafang")) {
			shebeiyanghu.setMafangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShebeiyanghuEntity> ew = new EntityWrapper<ShebeiyanghuEntity>();



		PageUtils page = shebeiyanghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiyanghu), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeiyanghuEntity shebeiyanghu, 
		HttpServletRequest request){
        EntityWrapper<ShebeiyanghuEntity> ew = new EntityWrapper<ShebeiyanghuEntity>();

		PageUtils page = shebeiyanghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeiyanghu), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeiyanghuEntity shebeiyanghu){
       	EntityWrapper<ShebeiyanghuEntity> ew = new EntityWrapper<ShebeiyanghuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeiyanghu, "shebeiyanghu")); 
        return R.ok().put("data", shebeiyanghuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeiyanghuEntity shebeiyanghu){
        EntityWrapper< ShebeiyanghuEntity> ew = new EntityWrapper< ShebeiyanghuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeiyanghu, "shebeiyanghu")); 
		ShebeiyanghuView shebeiyanghuView =  shebeiyanghuService.selectView(ew);
		return R.ok("查询设备养护成功").put("data", shebeiyanghuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeiyanghuEntity shebeiyanghu = shebeiyanghuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebeiyanghu,deSens);
        return R.ok().put("data", shebeiyanghu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeiyanghuEntity shebeiyanghu = shebeiyanghuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(shebeiyanghu,deSens);
        return R.ok().put("data", shebeiyanghu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeiyanghuEntity shebeiyanghu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebeiyanghu);
        shebeiyanghuService.insert(shebeiyanghu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShebeiyanghuEntity shebeiyanghu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shebeiyanghu);
        shebeiyanghuService.insert(shebeiyanghu);
        return R.ok().put("data",shebeiyanghu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShebeiyanghuEntity shebeiyanghu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeiyanghu);
        //全部更新
        shebeiyanghuService.updateById(shebeiyanghu);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shebeiyanghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
