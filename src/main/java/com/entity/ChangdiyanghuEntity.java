package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 场地养护
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@TableName("changdiyanghu")
public class ChangdiyanghuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChangdiyanghuEntity() {
		
	}
	
	public ChangdiyanghuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 场地名称
	 */
					
	private String changdimingcheng;
	
	/**
	 * 场地类型
	 */
					
	private String changdileixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 场地位置
	 */
					
	private String changdiweizhi;
	
	/**
	 * 养护时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date yanghushijian;
	
	/**
	 * 养护结果
	 */
					
	private String yanghujieguo;
	
	/**
	 * 养护记录
	 */
					
	private String yanghujilu;
	
	/**
	 * 马房账号
	 */
					
	private String mafangzhanghao;
	
	/**
	 * 马房姓名
	 */
					
	private String mafangxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：场地名称
	 */
	public void setChangdimingcheng(String changdimingcheng) {
		this.changdimingcheng = changdimingcheng;
	}
	/**
	 * 获取：场地名称
	 */
	public String getChangdimingcheng() {
		return changdimingcheng;
	}
	/**
	 * 设置：场地类型
	 */
	public void setChangdileixing(String changdileixing) {
		this.changdileixing = changdileixing;
	}
	/**
	 * 获取：场地类型
	 */
	public String getChangdileixing() {
		return changdileixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：场地位置
	 */
	public void setChangdiweizhi(String changdiweizhi) {
		this.changdiweizhi = changdiweizhi;
	}
	/**
	 * 获取：场地位置
	 */
	public String getChangdiweizhi() {
		return changdiweizhi;
	}
	/**
	 * 设置：养护时间
	 */
	public void setYanghushijian(Date yanghushijian) {
		this.yanghushijian = yanghushijian;
	}
	/**
	 * 获取：养护时间
	 */
	public Date getYanghushijian() {
		return yanghushijian;
	}
	/**
	 * 设置：养护结果
	 */
	public void setYanghujieguo(String yanghujieguo) {
		this.yanghujieguo = yanghujieguo;
	}
	/**
	 * 获取：养护结果
	 */
	public String getYanghujieguo() {
		return yanghujieguo;
	}
	/**
	 * 设置：养护记录
	 */
	public void setYanghujilu(String yanghujilu) {
		this.yanghujilu = yanghujilu;
	}
	/**
	 * 获取：养护记录
	 */
	public String getYanghujilu() {
		return yanghujilu;
	}
	/**
	 * 设置：马房账号
	 */
	public void setMafangzhanghao(String mafangzhanghao) {
		this.mafangzhanghao = mafangzhanghao;
	}
	/**
	 * 获取：马房账号
	 */
	public String getMafangzhanghao() {
		return mafangzhanghao;
	}
	/**
	 * 设置：马房姓名
	 */
	public void setMafangxingming(String mafangxingming) {
		this.mafangxingming = mafangxingming;
	}
	/**
	 * 获取：马房姓名
	 */
	public String getMafangxingming() {
		return mafangxingming;
	}

}
