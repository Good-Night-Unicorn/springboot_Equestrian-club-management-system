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

import com.entity.PaibanxinxiEntity;
import com.entity.view.PaibanxinxiView;

import com.service.PaibanxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 排班信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
@RestController
@RequestMapping("/paibanxinxi")
public class PaibanxinxiController {
    @Autowired
    private PaibanxinxiService paibanxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaibanxinxiEntity paibanxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			paibanxinxi.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PaibanxinxiEntity> ew = new EntityWrapper<PaibanxinxiEntity>();



		PageUtils page = paibanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paibanxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaibanxinxiEntity paibanxinxi, 
		HttpServletRequest request){
        EntityWrapper<PaibanxinxiEntity> ew = new EntityWrapper<PaibanxinxiEntity>();

		PageUtils page = paibanxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paibanxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaibanxinxiEntity paibanxinxi){
       	EntityWrapper<PaibanxinxiEntity> ew = new EntityWrapper<PaibanxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paibanxinxi, "paibanxinxi")); 
        return R.ok().put("data", paibanxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaibanxinxiEntity paibanxinxi){
        EntityWrapper< PaibanxinxiEntity> ew = new EntityWrapper< PaibanxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paibanxinxi, "paibanxinxi")); 
		PaibanxinxiView paibanxinxiView =  paibanxinxiService.selectView(ew);
		return R.ok("查询排班信息成功").put("data", paibanxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaibanxinxiEntity paibanxinxi = paibanxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(paibanxinxi,deSens);
        return R.ok().put("data", paibanxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaibanxinxiEntity paibanxinxi = paibanxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(paibanxinxi,deSens);
        return R.ok().put("data", paibanxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaibanxinxiEntity paibanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(paibanxinxi);
        paibanxinxiService.insert(paibanxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaibanxinxiEntity paibanxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(paibanxinxi);
        paibanxinxiService.insert(paibanxinxi);
        return R.ok().put("data",paibanxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaibanxinxiEntity paibanxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paibanxinxi);
        //全部更新
        paibanxinxiService.updateById(paibanxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paibanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
