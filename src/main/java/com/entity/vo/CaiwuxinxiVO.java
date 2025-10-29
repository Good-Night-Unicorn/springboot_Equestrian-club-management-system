package com.entity.vo;

import com.entity.CaiwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 财务信息
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
public class CaiwuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjiriqi;
				
	
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
