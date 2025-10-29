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

import com.entity.DiscussjiaolianxinxiEntity;
import com.entity.view.DiscussjiaolianxinxiView;

import com.service.DiscussjiaolianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 教练信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:19
 */
@RestController
@RequestMapping("/discussjiaolianxinxi")
public class DiscussjiaolianxinxiController {
    @Autowired
    private DiscussjiaolianxinxiService discussjiaolianxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiaolianxinxiEntity discussjiaolianxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscussjiaolianxinxiEntity> ew = new EntityWrapper<DiscussjiaolianxinxiEntity>();



		PageUtils page = discussjiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaolianxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiaolianxinxiEntity discussjiaolianxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiaolianxinxiEntity> ew = new EntityWrapper<DiscussjiaolianxinxiEntity>();

		PageUtils page = discussjiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaolianxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiaolianxinxiEntity discussjiaolianxinxi){
       	EntityWrapper<DiscussjiaolianxinxiEntity> ew = new EntityWrapper<DiscussjiaolianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiaolianxinxi, "discussjiaolianxinxi")); 
        return R.ok().put("data", discussjiaolianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiaolianxinxiEntity discussjiaolianxinxi){
        EntityWrapper< DiscussjiaolianxinxiEntity> ew = new EntityWrapper< DiscussjiaolianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiaolianxinxi, "discussjiaolianxinxi")); 
		DiscussjiaolianxinxiView discussjiaolianxinxiView =  discussjiaolianxinxiService.selectView(ew);
		return R.ok("查询教练信息评论表成功").put("data", discussjiaolianxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiaolianxinxiEntity discussjiaolianxinxi = discussjiaolianxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discussjiaolianxinxi,deSens);
        return R.ok().put("data", discussjiaolianxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiaolianxinxiEntity discussjiaolianxinxi = discussjiaolianxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(discussjiaolianxinxi,deSens);
        return R.ok().put("data", discussjiaolianxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjiaolianxinxiEntity discussjiaolianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiaolianxinxi);
        discussjiaolianxinxiService.insert(discussjiaolianxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiaolianxinxiEntity discussjiaolianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussjiaolianxinxi);
        discussjiaolianxinxiService.insert(discussjiaolianxinxi);
        return R.ok().put("data",discussjiaolianxinxi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjiaolianxinxiEntity discussjiaolianxinxi = discussjiaolianxinxiService.selectOne(new EntityWrapper<DiscussjiaolianxinxiEntity>().eq("", username));
        return R.ok().put("data", discussjiaolianxinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiaolianxinxiEntity discussjiaolianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiaolianxinxi);
        //全部更新
        discussjiaolianxinxiService.updateById(discussjiaolianxinxi);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjiaolianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiaolianxinxiEntity discussjiaolianxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiaolianxinxiEntity> ew = new EntityWrapper<DiscussjiaolianxinxiEntity>();
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
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussjiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiaolianxinxi), params), params));
        return R.ok().put("data", page);
    }











}
