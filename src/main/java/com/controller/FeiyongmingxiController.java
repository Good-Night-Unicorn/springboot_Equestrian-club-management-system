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

import com.entity.FeiyongmingxiEntity;
import com.entity.view.FeiyongmingxiView;

import com.service.FeiyongmingxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 费用明细
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@RestController
@RequestMapping("/feiyongmingxi")
public class FeiyongmingxiController {
    @Autowired
    private FeiyongmingxiService feiyongmingxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FeiyongmingxiEntity feiyongmingxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjishijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huiyuan")) {
			feiyongmingxi.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FeiyongmingxiEntity> ew = new EntityWrapper<FeiyongmingxiEntity>();
                if(dengjishijianstart!=null) ew.ge("dengjishijian", dengjishijianstart);
                if(dengjishijianend!=null) ew.le("dengjishijian", dengjishijianend);



		PageUtils page = feiyongmingxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, feiyongmingxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FeiyongmingxiEntity feiyongmingxi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjishijianend,
		HttpServletRequest request){
        EntityWrapper<FeiyongmingxiEntity> ew = new EntityWrapper<FeiyongmingxiEntity>();
                if(dengjishijianstart!=null) ew.ge("dengjishijian", dengjishijianstart);
                if(dengjishijianend!=null) ew.le("dengjishijian", dengjishijianend);

		PageUtils page = feiyongmingxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, feiyongmingxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FeiyongmingxiEntity feiyongmingxi){
       	EntityWrapper<FeiyongmingxiEntity> ew = new EntityWrapper<FeiyongmingxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( feiyongmingxi, "feiyongmingxi")); 
        return R.ok().put("data", feiyongmingxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FeiyongmingxiEntity feiyongmingxi){
        EntityWrapper< FeiyongmingxiEntity> ew = new EntityWrapper< FeiyongmingxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( feiyongmingxi, "feiyongmingxi")); 
		FeiyongmingxiView feiyongmingxiView =  feiyongmingxiService.selectView(ew);
		return R.ok("查询费用明细成功").put("data", feiyongmingxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FeiyongmingxiEntity feiyongmingxi = feiyongmingxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(feiyongmingxi,deSens);
        return R.ok().put("data", feiyongmingxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FeiyongmingxiEntity feiyongmingxi = feiyongmingxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(feiyongmingxi,deSens);
        return R.ok().put("data", feiyongmingxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FeiyongmingxiEntity feiyongmingxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(feiyongmingxi);
        feiyongmingxiService.insert(feiyongmingxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FeiyongmingxiEntity feiyongmingxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(feiyongmingxi);
        feiyongmingxiService.insert(feiyongmingxi);
        return R.ok().put("data",feiyongmingxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FeiyongmingxiEntity feiyongmingxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(feiyongmingxi);
        //全部更新
        feiyongmingxiService.updateById(feiyongmingxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        feiyongmingxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
