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

import com.entity.YuyuesijiaoEntity;
import com.entity.view.YuyuesijiaoView;

import com.service.YuyuesijiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约私教
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@RestController
@RequestMapping("/yuyuesijiao")
public class YuyuesijiaoController {
    @Autowired
    private YuyuesijiaoService yuyuesijiaoService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuesijiaoEntity yuyuesijiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			yuyuesijiao.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huiyuan")) {
			yuyuesijiao.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuesijiaoEntity> ew = new EntityWrapper<YuyuesijiaoEntity>();



		PageUtils page = yuyuesijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuesijiao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuesijiaoEntity yuyuesijiao, 
		HttpServletRequest request){
        EntityWrapper<YuyuesijiaoEntity> ew = new EntityWrapper<YuyuesijiaoEntity>();

		PageUtils page = yuyuesijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuesijiao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuesijiaoEntity yuyuesijiao){
       	EntityWrapper<YuyuesijiaoEntity> ew = new EntityWrapper<YuyuesijiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuesijiao, "yuyuesijiao")); 
        return R.ok().put("data", yuyuesijiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuesijiaoEntity yuyuesijiao){
        EntityWrapper< YuyuesijiaoEntity> ew = new EntityWrapper< YuyuesijiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuesijiao, "yuyuesijiao")); 
		YuyuesijiaoView yuyuesijiaoView =  yuyuesijiaoService.selectView(ew);
		return R.ok("查询预约私教成功").put("data", yuyuesijiaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuesijiaoEntity yuyuesijiao = yuyuesijiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(yuyuesijiao,deSens);
        return R.ok().put("data", yuyuesijiao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuesijiaoEntity yuyuesijiao = yuyuesijiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(yuyuesijiao,deSens);
        return R.ok().put("data", yuyuesijiao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuesijiaoEntity yuyuesijiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuyuesijiao);
        yuyuesijiaoService.insert(yuyuesijiao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuesijiaoEntity yuyuesijiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuyuesijiao);
        yuyuesijiaoService.insert(yuyuesijiao);
        return R.ok().put("data",yuyuesijiao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuesijiaoEntity yuyuesijiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuesijiao);
        //全部更新
        yuyuesijiaoService.updateById(yuyuesijiao);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<YuyuesijiaoEntity> list = new ArrayList<YuyuesijiaoEntity>();
        for(Long id : ids) {
            YuyuesijiaoEntity yuyuesijiao = yuyuesijiaoService.selectById(id);
            yuyuesijiao.setSfsh(sfsh);
            yuyuesijiao.setShhf(shhf);
            list.add(yuyuesijiao);
        }
        yuyuesijiaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuesijiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
