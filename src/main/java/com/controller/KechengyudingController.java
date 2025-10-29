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

import com.entity.KechengyudingEntity;
import com.entity.view.KechengyudingView;

import com.service.KechengyudingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程预订
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@RestController
@RequestMapping("/kechengyuding")
public class KechengyudingController {
    @Autowired
    private KechengyudingService kechengyudingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengyudingEntity kechengyuding,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			kechengyuding.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huiyuan")) {
			kechengyuding.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengyudingEntity> ew = new EntityWrapper<KechengyudingEntity>();



		PageUtils page = kechengyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengyuding), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengyudingEntity kechengyuding, 
		HttpServletRequest request){
        EntityWrapper<KechengyudingEntity> ew = new EntityWrapper<KechengyudingEntity>();

		PageUtils page = kechengyudingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengyuding), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengyudingEntity kechengyuding){
       	EntityWrapper<KechengyudingEntity> ew = new EntityWrapper<KechengyudingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengyuding, "kechengyuding")); 
        return R.ok().put("data", kechengyudingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengyudingEntity kechengyuding){
        EntityWrapper< KechengyudingEntity> ew = new EntityWrapper< KechengyudingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengyuding, "kechengyuding")); 
		KechengyudingView kechengyudingView =  kechengyudingService.selectView(ew);
		return R.ok("查询课程预订成功").put("data", kechengyudingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengyudingEntity kechengyuding = kechengyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kechengyuding,deSens);
        return R.ok().put("data", kechengyuding);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengyudingEntity kechengyuding = kechengyudingService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(kechengyuding,deSens);
        return R.ok().put("data", kechengyuding);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengyudingEntity kechengyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengyuding);
        kechengyudingService.insert(kechengyuding);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengyudingEntity kechengyuding, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kechengyuding);
        kechengyudingService.insert(kechengyuding);
        return R.ok().put("data",kechengyuding.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengyudingEntity kechengyuding, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengyuding);
        //全部更新
        kechengyudingService.updateById(kechengyuding);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<KechengyudingEntity> list = new ArrayList<KechengyudingEntity>();
        for(Long id : ids) {
            KechengyudingEntity kechengyuding = kechengyudingService.selectById(id);
            kechengyuding.setSfsh(sfsh);
            kechengyuding.setShhf(shhf);
            list.add(kechengyuding);
        }
        kechengyudingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
