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

import com.entity.ChangdixinxiEntity;
import com.entity.view.ChangdixinxiView;

import com.service.ChangdixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 场地信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/changdixinxi")
public class ChangdixinxiController {
    @Autowired
    private ChangdixinxiService changdixinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi,
		HttpServletRequest request){
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();



		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi, 
		HttpServletRequest request){
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();

		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdixinxiEntity changdixinxi){
       	EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdixinxi, "changdixinxi")); 
        return R.ok().put("data", changdixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdixinxiEntity changdixinxi){
        EntityWrapper< ChangdixinxiEntity> ew = new EntityWrapper< ChangdixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdixinxi, "changdixinxi")); 
		ChangdixinxiView changdixinxiView =  changdixinxiService.selectView(ew);
		return R.ok("查询场地信息成功").put("data", changdixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdixinxiEntity changdixinxi = changdixinxiService.selectById(id);
		changdixinxi.setClicknum(changdixinxi.getClicknum()+1);
		changdixinxi.setClicktime(new Date());
		changdixinxiService.updateById(changdixinxi);
        changdixinxi = changdixinxiService.selectView(new EntityWrapper<ChangdixinxiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changdixinxi,deSens);
        return R.ok().put("data", changdixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdixinxiEntity changdixinxi = changdixinxiService.selectById(id);
		changdixinxi.setClicknum(changdixinxi.getClicknum()+1);
		changdixinxi.setClicktime(new Date());
		changdixinxiService.updateById(changdixinxi);
        changdixinxi = changdixinxiService.selectView(new EntityWrapper<ChangdixinxiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(changdixinxi,deSens);
        return R.ok().put("data", changdixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changdixinxi);
        changdixinxiService.insert(changdixinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(changdixinxi);
        changdixinxiService.insert(changdixinxi);
        return R.ok().put("data",changdixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdixinxi);
        //全部更新
        changdixinxiService.updateById(changdixinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi, HttpServletRequest request,String pre){
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
        return R.ok().put("data", page);
    }











}
