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

import com.entity.JiaolianxinxiEntity;
import com.entity.view.JiaolianxinxiView;

import com.service.JiaolianxinxiService;
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
 * 教练信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@RestController
@RequestMapping("/jiaolianxinxi")
public class JiaolianxinxiController {
    @Autowired
    private JiaolianxinxiService jiaolianxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaolianxinxiEntity jiaolianxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			jiaolianxinxi.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();



		PageUtils page = jiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaolianxinxiEntity jiaolianxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();

		PageUtils page = jiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaolianxinxiEntity jiaolianxinxi){
       	EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaolianxinxi, "jiaolianxinxi")); 
        return R.ok().put("data", jiaolianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaolianxinxiEntity jiaolianxinxi){
        EntityWrapper< JiaolianxinxiEntity> ew = new EntityWrapper< JiaolianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaolianxinxi, "jiaolianxinxi")); 
		JiaolianxinxiView jiaolianxinxiView =  jiaolianxinxiService.selectView(ew);
		return R.ok("查询教练信息成功").put("data", jiaolianxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaolianxinxiEntity jiaolianxinxi = jiaolianxinxiService.selectById(id);
		jiaolianxinxi.setClicknum(jiaolianxinxi.getClicknum()+1);
		jiaolianxinxi.setClicktime(new Date());
		jiaolianxinxiService.updateById(jiaolianxinxi);
        jiaolianxinxi = jiaolianxinxiService.selectView(new EntityWrapper<JiaolianxinxiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiaolianxinxi,deSens);
        return R.ok().put("data", jiaolianxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaolianxinxiEntity jiaolianxinxi = jiaolianxinxiService.selectById(id);
		jiaolianxinxi.setClicknum(jiaolianxinxi.getClicknum()+1);
		jiaolianxinxi.setClicktime(new Date());
		jiaolianxinxiService.updateById(jiaolianxinxi);
        jiaolianxinxi = jiaolianxinxiService.selectView(new EntityWrapper<JiaolianxinxiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jiaolianxinxi,deSens);
        return R.ok().put("data", jiaolianxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiaolianxinxi);
        jiaolianxinxiService.insert(jiaolianxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiaolianxinxi);
        jiaolianxinxiService.insert(jiaolianxinxi);
        return R.ok().put("data",jiaolianxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaolianxinxi);
        //全部更新
        jiaolianxinxiService.updateById(jiaolianxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaolianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request,String pre){
        EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();
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
		PageUtils page = jiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianxinxi), params), params));
        return R.ok().put("data", page);
    }











}
