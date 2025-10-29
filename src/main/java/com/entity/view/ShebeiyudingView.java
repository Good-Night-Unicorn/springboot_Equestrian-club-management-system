package com.entity.view;

import com.entity.ShebeiyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 设备预订
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@TableName("shebeiyuding")
public class ShebeiyudingView  extends ShebeiyudingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShebeiyudingView(){
	}
 
 	public ShebeiyudingView(ShebeiyudingEntity shebeiyudingEntity){
 	try {
			BeanUtils.copyProperties(this, shebeiyudingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
