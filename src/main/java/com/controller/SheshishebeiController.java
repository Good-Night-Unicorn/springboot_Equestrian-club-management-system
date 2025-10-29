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

import com.entity.SheshishebeiEntity;
import com.entity.view.SheshishebeiView;

import com.service.SheshishebeiService;
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
 * 设施设备
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/sheshishebei")
public class SheshishebeiController {
    @Autowired
    private SheshishebeiService sheshishebeiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SheshishebeiEntity sheshishebei,
		HttpServletRequest request){
        EntityWrapper<SheshishebeiEntity> ew = new EntityWrapper<SheshishebeiEntity>();



		PageUtils page = sheshishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheshishebei), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SheshishebeiEntity sheshishebei, 
		HttpServletRequest request){
        EntityWrapper<SheshishebeiEntity> ew = new EntityWrapper<SheshishebeiEntity>();

		PageUtils page = sheshishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheshishebei), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SheshishebeiEntity sheshishebei){
       	EntityWrapper<SheshishebeiEntity> ew = new EntityWrapper<SheshishebeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sheshishebei, "sheshishebei")); 
        return R.ok().put("data", sheshishebeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SheshishebeiEntity sheshishebei){
        EntityWrapper< SheshishebeiEntity> ew = new EntityWrapper< SheshishebeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sheshishebei, "sheshishebei")); 
		SheshishebeiView sheshishebeiView =  sheshishebeiService.selectView(ew);
		return R.ok("查询设施设备成功").put("data", sheshishebeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SheshishebeiEntity sheshishebei = sheshishebeiService.selectById(id);
		sheshishebei.setClicknum(sheshishebei.getClicknum()+1);
		sheshishebei.setClicktime(new Date());
		sheshishebeiService.updateById(sheshishebei);
        sheshishebei = sheshishebeiService.selectView(new EntityWrapper<SheshishebeiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(sheshishebei,deSens);
        return R.ok().put("data", sheshishebei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SheshishebeiEntity sheshishebei = sheshishebeiService.selectById(id);
		sheshishebei.setClicknum(sheshishebei.getClicknum()+1);
		sheshishebei.setClicktime(new Date());
		sheshishebeiService.updateById(sheshishebei);
        sheshishebei = sheshishebeiService.selectView(new EntityWrapper<SheshishebeiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(sheshishebei,deSens);
        return R.ok().put("data", sheshishebei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SheshishebeiEntity sheshishebei, HttpServletRequest request){
        if(sheshishebeiService.selectCount(new EntityWrapper<SheshishebeiEntity>().eq("shebeibianhao", sheshishebei.getShebeibianhao()))>0) {
            return R.error("设备编号已存在");
        }
    	//ValidatorUtils.validateEntity(sheshishebei);
        sheshishebeiService.insert(sheshishebei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SheshishebeiEntity sheshishebei, HttpServletRequest request){
        if(sheshishebeiService.selectCount(new EntityWrapper<SheshishebeiEntity>().eq("shebeibianhao", sheshishebei.getShebeibianhao()))>0) {
            return R.error("设备编号已存在");
        }
    	//ValidatorUtils.validateEntity(sheshishebei);
        sheshishebeiService.insert(sheshishebei);
        return R.ok().put("data",sheshishebei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SheshishebeiEntity sheshishebei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheshishebei);
        if(sheshishebeiService.selectCount(new EntityWrapper<SheshishebeiEntity>().ne("id", sheshishebei.getId()).eq("shebeibianhao", sheshishebei.getShebeibianhao()))>0) {
            return R.error("设备编号已存在");
        }
        //全部更新
        sheshishebeiService.updateById(sheshishebei);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sheshishebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SheshishebeiEntity sheshishebei, HttpServletRequest request,String pre){
        EntityWrapper<SheshishebeiEntity> ew = new EntityWrapper<SheshishebeiEntity>();
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
		PageUtils page = sheshishebeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheshishebei), params), params));
        return R.ok().put("data", page);
    }











}
