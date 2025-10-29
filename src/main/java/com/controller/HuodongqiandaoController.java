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

import com.entity.HuodongqiandaoEntity;
import com.entity.view.HuodongqiandaoView;

import com.service.HuodongqiandaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 活动签到
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
@RestController
@RequestMapping("/huodongqiandao")
public class HuodongqiandaoController {
    @Autowired
    private HuodongqiandaoService huodongqiandaoService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongqiandaoEntity huodongqiandao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			huodongqiandao.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaolian")) {
			huodongqiandao.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuodongqiandaoEntity> ew = new EntityWrapper<HuodongqiandaoEntity>();



		PageUtils page = huodongqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongqiandao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongqiandaoEntity huodongqiandao, 
		HttpServletRequest request){
        EntityWrapper<HuodongqiandaoEntity> ew = new EntityWrapper<HuodongqiandaoEntity>();

		PageUtils page = huodongqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongqiandao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongqiandaoEntity huodongqiandao){
       	EntityWrapper<HuodongqiandaoEntity> ew = new EntityWrapper<HuodongqiandaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongqiandao, "huodongqiandao")); 
        return R.ok().put("data", huodongqiandaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongqiandaoEntity huodongqiandao){
        EntityWrapper< HuodongqiandaoEntity> ew = new EntityWrapper< HuodongqiandaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongqiandao, "huodongqiandao")); 
		HuodongqiandaoView huodongqiandaoView =  huodongqiandaoService.selectView(ew);
		return R.ok("查询活动签到成功").put("data", huodongqiandaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongqiandaoEntity huodongqiandao = huodongqiandaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(huodongqiandao,deSens);
        return R.ok().put("data", huodongqiandao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongqiandaoEntity huodongqiandao = huodongqiandaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(huodongqiandao,deSens);
        return R.ok().put("data", huodongqiandao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongqiandaoEntity huodongqiandao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(huodongqiandao);
        huodongqiandaoService.insert(huodongqiandao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongqiandaoEntity huodongqiandao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(huodongqiandao);
        huodongqiandaoService.insert(huodongqiandao);
        return R.ok().put("data",huodongqiandao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongqiandaoEntity huodongqiandao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongqiandao);
        //全部更新
        huodongqiandaoService.updateById(huodongqiandao);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<HuodongqiandaoEntity> list = new ArrayList<HuodongqiandaoEntity>();
        for(Long id : ids) {
            HuodongqiandaoEntity huodongqiandao = huodongqiandaoService.selectById(id);
            huodongqiandao.setSfsh(sfsh);
            huodongqiandao.setShhf(shhf);
            list.add(huodongqiandao);
        }
        huodongqiandaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongqiandaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
