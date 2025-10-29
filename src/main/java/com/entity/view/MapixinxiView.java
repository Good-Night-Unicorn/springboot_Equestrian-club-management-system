package com.entity.view;

import com.entity.MapixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 马匹信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@TableName("mapixinxi")
public class MapixinxiView  extends MapixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MapixinxiView(){
	}
 
 	public MapixinxiView(MapixinxiEntity mapixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, mapixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
