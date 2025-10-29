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

import com.entity.ChangdiyanghuEntity;
import com.entity.view.ChangdiyanghuView;

import com.service.ChangdiyanghuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场地养护
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/changdiyanghu")
public class ChangdiyanghuController {
    @Autowired
    private ChangdiyanghuService changdiyanghuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdiyanghuEntity changdiyanghu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("mafang")) {
			changdiyanghu.setMafangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChangdiyanghuEntity> ew = new EntityWrapper<ChangdiyanghuEntity>();



		PageUtils page = changdiyanghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyanghu), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangdiyanghuEntity changdiyanghu, 
		HttpServletRequest request){
        EntityWrapper<ChangdiyanghuEntity> ew = new EntityWrapper<ChangdiyanghuEntity>();

		PageUtils page = changdiyanghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyanghu), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdiyanghuEntity changdiyanghu){
       	EntityWrapper<ChangdiyanghuEntity> ew = new EntityWrapper<ChangdiyanghuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdiyanghu, "changdiyanghu")); 
        return R.ok().put("data", changdiyanghuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdiyanghuEntity changdiyanghu){
        EntityWrapper< ChangdiyanghuEntity> ew = new EntityWrapper< ChangdiyanghuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdiyanghu, "changdiyanghu")); 
		ChangdiyanghuView changdiyanghuView =  changdiyanghuService.selectView(ew);
		return R.ok("查询场地养护成功").put("data", changdiyanghuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdiyanghuEntity changdiyanghu = changdiyanghuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changdiyanghu,deSens);
        return R.ok().put("data", changdiyanghu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdiyanghuEntity changdiyanghu = changdiyanghuService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changdiyanghu,deSens);
        return R.ok().put("data", changdiyanghu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdiyanghuEntity changdiyanghu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changdiyanghu);
        changdiyanghuService.insert(changdiyanghu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdiyanghuEntity changdiyanghu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changdiyanghu);
        changdiyanghuService.insert(changdiyanghu);
        return R.ok().put("data",changdiyanghu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdiyanghuEntity changdiyanghu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdiyanghu);
        //全部更新
        changdiyanghuService.updateById(changdiyanghu);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdiyanghuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
