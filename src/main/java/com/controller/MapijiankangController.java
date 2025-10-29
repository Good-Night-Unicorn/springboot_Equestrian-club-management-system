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

import com.entity.MapijiankangEntity;
import com.entity.view.MapijiankangView;

import com.service.MapijiankangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 马匹健康
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/mapijiankang")
public class MapijiankangController {
    @Autowired
    private MapijiankangService mapijiankangService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MapijiankangEntity mapijiankang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("mafang")) {
			mapijiankang.setMafangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MapijiankangEntity> ew = new EntityWrapper<MapijiankangEntity>();



		PageUtils page = mapijiankangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mapijiankang), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MapijiankangEntity mapijiankang, 
		HttpServletRequest request){
        EntityWrapper<MapijiankangEntity> ew = new EntityWrapper<MapijiankangEntity>();

		PageUtils page = mapijiankangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mapijiankang), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MapijiankangEntity mapijiankang){
       	EntityWrapper<MapijiankangEntity> ew = new EntityWrapper<MapijiankangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mapijiankang, "mapijiankang")); 
        return R.ok().put("data", mapijiankangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MapijiankangEntity mapijiankang){
        EntityWrapper< MapijiankangEntity> ew = new EntityWrapper< MapijiankangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mapijiankang, "mapijiankang")); 
		MapijiankangView mapijiankangView =  mapijiankangService.selectView(ew);
		return R.ok("查询马匹健康成功").put("data", mapijiankangView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MapijiankangEntity mapijiankang = mapijiankangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(mapijiankang,deSens);
        return R.ok().put("data", mapijiankang);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MapijiankangEntity mapijiankang = mapijiankangService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(mapijiankang,deSens);
        return R.ok().put("data", mapijiankang);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MapijiankangEntity mapijiankang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mapijiankang);
        mapijiankangService.insert(mapijiankang);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MapijiankangEntity mapijiankang, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(mapijiankang);
        mapijiankangService.insert(mapijiankang);
        return R.ok().put("data",mapijiankang.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MapijiankangEntity mapijiankang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mapijiankang);
        //全部更新
        mapijiankangService.updateById(mapijiankang);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mapijiankangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
