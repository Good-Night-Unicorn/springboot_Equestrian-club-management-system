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

import com.entity.JifenshangpinEntity;
import com.entity.view.JifenshangpinView;

import com.service.JifenshangpinService;
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
 * 积分商品
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
@RestController
@RequestMapping("/jifenshangpin")
public class JifenshangpinController {
    @Autowired
    private JifenshangpinService jifenshangpinService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JifenshangpinEntity jifenshangpin,
		HttpServletRequest request){
        EntityWrapper<JifenshangpinEntity> ew = new EntityWrapper<JifenshangpinEntity>();



		PageUtils page = jifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenshangpin), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JifenshangpinEntity jifenshangpin, 
		HttpServletRequest request){
        EntityWrapper<JifenshangpinEntity> ew = new EntityWrapper<JifenshangpinEntity>();

		PageUtils page = jifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenshangpin), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JifenshangpinEntity jifenshangpin){
       	EntityWrapper<JifenshangpinEntity> ew = new EntityWrapper<JifenshangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jifenshangpin, "jifenshangpin")); 
        return R.ok().put("data", jifenshangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JifenshangpinEntity jifenshangpin){
        EntityWrapper< JifenshangpinEntity> ew = new EntityWrapper< JifenshangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jifenshangpin, "jifenshangpin")); 
		JifenshangpinView jifenshangpinView =  jifenshangpinService.selectView(ew);
		return R.ok("查询积分商品成功").put("data", jifenshangpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JifenshangpinEntity jifenshangpin = jifenshangpinService.selectById(id);
		jifenshangpin.setClicknum(jifenshangpin.getClicknum()+1);
		jifenshangpin.setClicktime(new Date());
		jifenshangpinService.updateById(jifenshangpin);
        jifenshangpin = jifenshangpinService.selectView(new EntityWrapper<JifenshangpinEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jifenshangpin,deSens);
        return R.ok().put("data", jifenshangpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JifenshangpinEntity jifenshangpin = jifenshangpinService.selectById(id);
		jifenshangpin.setClicknum(jifenshangpin.getClicknum()+1);
		jifenshangpin.setClicktime(new Date());
		jifenshangpinService.updateById(jifenshangpin);
        jifenshangpin = jifenshangpinService.selectView(new EntityWrapper<JifenshangpinEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(jifenshangpin,deSens);
        return R.ok().put("data", jifenshangpin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JifenshangpinEntity jifenshangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jifenshangpin);
        jifenshangpinService.insert(jifenshangpin);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JifenshangpinEntity jifenshangpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jifenshangpin);
        jifenshangpinService.insert(jifenshangpin);
        return R.ok().put("data",jifenshangpin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JifenshangpinEntity jifenshangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jifenshangpin);
        //全部更新
        jifenshangpinService.updateById(jifenshangpin);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jifenshangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JifenshangpinEntity jifenshangpin, HttpServletRequest request,String pre){
        EntityWrapper<JifenshangpinEntity> ew = new EntityWrapper<JifenshangpinEntity>();
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
		PageUtils page = jifenshangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jifenshangpin), params), params));
        return R.ok().put("data", page);
    }











}
