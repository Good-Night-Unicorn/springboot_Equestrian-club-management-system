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

import com.entity.ChangdiyudingEntity;
import com.entity.view.ChangdiyudingView;

import com.service.ChangdiyudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场地预订
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/changdiyuding")
public class ChangdiyudingController {
    @Autowired
    private ChangdiyudingService changdiyudingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdiyudingEntity changdiyuding,
		HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            changdiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
        }
        EntityWrapper<ChangdiyudingEntity> ew = new EntityWrapper<ChangdiyudingEntity>();



		PageUtils page = changdiyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyuding), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangdiyudingEntity changdiyuding, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		changdiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<ChangdiyudingEntity> ew = new EntityWrapper<ChangdiyudingEntity>();

		PageUtils page = changdiyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyuding), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdiyudingEntity changdiyuding){
       	EntityWrapper<ChangdiyudingEntity> ew = new EntityWrapper<ChangdiyudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdiyuding, "changdiyuding")); 
        return R.ok().put("data", changdiyudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdiyudingEntity changdiyuding){
        EntityWrapper< ChangdiyudingEntity> ew = new EntityWrapper< ChangdiyudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdiyuding, "changdiyuding")); 
		ChangdiyudingView changdiyudingView =  changdiyudingService.selectView(ew);
		return R.ok("查询场地预订成功").put("data", changdiyudingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdiyudingEntity changdiyuding = changdiyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changdiyuding,deSens);
        return R.ok().put("data", changdiyuding);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdiyudingEntity changdiyuding = changdiyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changdiyuding,deSens);
        return R.ok().put("data", changdiyuding);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdiyudingEntity changdiyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changdiyuding);
    	changdiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
        changdiyudingService.insert(changdiyuding);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdiyudingEntity changdiyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changdiyuding);
    	changdiyuding.setUserid((Long)request.getSession().getAttribute("userId"));
        changdiyudingService.insert(changdiyuding);
        return R.ok().put("data",changdiyuding.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdiyudingEntity changdiyuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdiyuding);
        //全部更新
        changdiyudingService.updateById(changdiyuding);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdiyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
