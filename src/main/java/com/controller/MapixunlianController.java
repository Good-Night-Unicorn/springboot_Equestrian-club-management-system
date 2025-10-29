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

import com.entity.MapixunlianEntity;
import com.entity.view.MapixunlianView;

import com.service.MapixunlianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 马匹训练
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@RestController
@RequestMapping("/mapixunlian")
public class MapixunlianController {
    @Autowired
    private MapixunlianService mapixunlianService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MapixunlianEntity mapixunlian,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			mapixunlian.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MapixunlianEntity> ew = new EntityWrapper<MapixunlianEntity>();



		PageUtils page = mapixunlianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mapixunlian), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MapixunlianEntity mapixunlian, 
		HttpServletRequest request){
        EntityWrapper<MapixunlianEntity> ew = new EntityWrapper<MapixunlianEntity>();

		PageUtils page = mapixunlianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mapixunlian), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MapixunlianEntity mapixunlian){
       	EntityWrapper<MapixunlianEntity> ew = new EntityWrapper<MapixunlianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mapixunlian, "mapixunlian")); 
        return R.ok().put("data", mapixunlianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MapixunlianEntity mapixunlian){
        EntityWrapper< MapixunlianEntity> ew = new EntityWrapper< MapixunlianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mapixunlian, "mapixunlian")); 
		MapixunlianView mapixunlianView =  mapixunlianService.selectView(ew);
		return R.ok("查询马匹训练成功").put("data", mapixunlianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MapixunlianEntity mapixunlian = mapixunlianService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(mapixunlian,deSens);
        return R.ok().put("data", mapixunlian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MapixunlianEntity mapixunlian = mapixunlianService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(mapixunlian,deSens);
        return R.ok().put("data", mapixunlian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MapixunlianEntity mapixunlian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mapixunlian);
        mapixunlianService.insert(mapixunlian);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MapixunlianEntity mapixunlian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mapixunlian);
        mapixunlianService.insert(mapixunlian);
        return R.ok().put("data",mapixunlian.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MapixunlianEntity mapixunlian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mapixunlian);
        //全部更新
        mapixunlianService.updateById(mapixunlian);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mapixunlianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
