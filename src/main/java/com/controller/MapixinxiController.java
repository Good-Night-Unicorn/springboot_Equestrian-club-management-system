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

import com.entity.MapixinxiEntity;
import com.entity.view.MapixinxiView;

import com.service.MapixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 马匹信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@RestController
@RequestMapping("/mapixinxi")
public class MapixinxiController {
    @Autowired
    private MapixinxiService mapixinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MapixinxiEntity mapixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			mapixinxi.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MapixinxiEntity> ew = new EntityWrapper<MapixinxiEntity>();



		PageUtils page = mapixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mapixinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MapixinxiEntity mapixinxi, 
		HttpServletRequest request){
        EntityWrapper<MapixinxiEntity> ew = new EntityWrapper<MapixinxiEntity>();

		PageUtils page = mapixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mapixinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MapixinxiEntity mapixinxi){
       	EntityWrapper<MapixinxiEntity> ew = new EntityWrapper<MapixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mapixinxi, "mapixinxi")); 
        return R.ok().put("data", mapixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MapixinxiEntity mapixinxi){
        EntityWrapper< MapixinxiEntity> ew = new EntityWrapper< MapixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mapixinxi, "mapixinxi")); 
		MapixinxiView mapixinxiView =  mapixinxiService.selectView(ew);
		return R.ok("查询马匹信息成功").put("data", mapixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MapixinxiEntity mapixinxi = mapixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(mapixinxi,deSens);
        return R.ok().put("data", mapixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MapixinxiEntity mapixinxi = mapixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(mapixinxi,deSens);
        return R.ok().put("data", mapixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MapixinxiEntity mapixinxi, HttpServletRequest request){
        if(mapixinxiService.selectCount(new EntityWrapper<MapixinxiEntity>().eq("mapibianhao", mapixinxi.getMapibianhao()))>0) {
            return R.error("马匹编号已存在");
        }
    	//ValidatorUtils.validateEntity(mapixinxi);
        mapixinxiService.insert(mapixinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MapixinxiEntity mapixinxi, HttpServletRequest request){
        if(mapixinxiService.selectCount(new EntityWrapper<MapixinxiEntity>().eq("mapibianhao", mapixinxi.getMapibianhao()))>0) {
            return R.error("马匹编号已存在");
        }
    	//ValidatorUtils.validateEntity(mapixinxi);
        mapixinxiService.insert(mapixinxi);
        return R.ok().put("data",mapixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MapixinxiEntity mapixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mapixinxi);
        if(mapixinxiService.selectCount(new EntityWrapper<MapixinxiEntity>().ne("id", mapixinxi.getId()).eq("mapibianhao", mapixinxi.getMapibianhao()))>0) {
            return R.error("马匹编号已存在");
        }
        //全部更新
        mapixinxiService.updateById(mapixinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mapixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
