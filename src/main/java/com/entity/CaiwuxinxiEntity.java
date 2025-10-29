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
 * 财务信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
@TableName("caiwuxinxi")
public class CaiwuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CaiwuxinxiEntity() {
		
	}
	
	public CaiwuxinxiEntity(T t) {
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
	 * 财务编号
	 */
					
	private String caiwubianhao;
	
	/**
	 * 财务名称
	 */
					
	private String caiwumingcheng;
	
	/**
	 * 收入金额
	 */
					
	private Double shourujine;
	
	/**
	 * 支出金额
	 */
					
	private Double zhichujine;
	
	/**
	 * 结余金额
	 */
					
	private Double jieyujine;
	
	/**
	 * 账务明细
	 */
					
	private String zhangwumingxi;
	
	/**
	 * 登记日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date dengjiriqi;
	
	
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
	 * 设置：财务编号
	 */
	public void setCaiwubianhao(String caiwubianhao) {
		this.caiwubianhao = caiwubianhao;
	}
	/**
	 * 获取：财务编号
	 */
	public String getCaiwubianhao() {
		return caiwubianhao;
	}
	/**
	 * 设置：财务名称
	 */
	public void setCaiwumingcheng(String caiwumingcheng) {
		this.caiwumingcheng = caiwumingcheng;
	}
	/**
	 * 获取：财务名称
	 */
	public String getCaiwumingcheng() {
		return caiwumingcheng;
	}
	/**
	 * 设置：收入金额
	 */
	public void setShourujine(Double shourujine) {
		this.shourujine = shourujine;
	}
	/**
	 * 获取：收入金额
	 */
	public Double getShourujine() {
		return shourujine;
	}
	/**
	 * 设置：支出金额
	 */
	public void setZhichujine(Double zhichujine) {
		this.zhichujine = zhichujine;
	}
	/**
	 * 获取：支出金额
	 */
	public Double getZhichujine() {
		return zhichujine;
	}
	/**
	 * 设置：结余金额
	 */
	public void setJieyujine(Double jieyujine) {
		this.jieyujine = jieyujine;
	}
	/**
	 * 获取：结余金额
	 */
	public Double getJieyujine() {
		return jieyujine;
	}
	/**
	 * 设置：账务明细
	 */
	public void setZhangwumingxi(String zhangwumingxi) {
		this.zhangwumingxi = zhangwumingxi;
	}
	/**
	 * 获取：账务明细
	 */
	public String getZhangwumingxi() {
		return zhangwumingxi;
	}
	/**
	 * 设置：登记日期
	 */
	public void setDengjiriqi(Date dengjiriqi) {
		this.dengjiriqi = dengjiriqi;
	}
	/**
	 * 获取：登记日期
	 */
	public Date getDengjiriqi() {
		return dengjiriqi;
	}

}
