package com.entity.view;

import com.entity.MafangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 马房管理员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:14
 */
@TableName("mafang")
public class MafangView  extends MafangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MafangView(){
	}
 
 	public MafangView(MafangEntity mafangEntity){
 	try {
			BeanUtils.copyProperties(this, mafangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
