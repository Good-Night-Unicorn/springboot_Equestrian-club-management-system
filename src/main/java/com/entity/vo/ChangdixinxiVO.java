package com.entity.vo;

import com.entity.ChangdixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 场地信息
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public class ChangdixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 场地状态
	 */
	
	private String changdizhuangtai;
		
	/**
	 * 可约时段
	 */
	
	private String keyueshiduan;
		
	/**
	 * 设施设备
	 */
	
	private String sheshishebei;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 场地规约
	 */
	
	private String changdiguiyue;
		
	/**
	 * 场地详情
	 */
	
	private String changdixiangqing;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：场地状态
	 */
	 
	public void setChangdizhuangtai(String changdizhuangtai) {
		this.changdizhuangtai = changdizhuangtai;
	}
	
	/**
	 * 获取：场地状态
	 */
	public String getChangdizhuangtai() {
		return changdizhuangtai;
	}
				
	
	/**
	 * 设置：可约时段
	 */
	 
	public void setKeyueshiduan(String keyueshiduan) {
		this.keyueshiduan = keyueshiduan;
	}
	
	/**
	 * 获取：可约时段
	 */
	public String getKeyueshiduan() {
		return keyueshiduan;
	}
				
	
	/**
	 * 设置：设施设备
	 */
	 
	public void setSheshishebei(String sheshishebei) {
		this.sheshishebei = sheshishebei;
	}
	
	/**
	 * 获取：设施设备
	 */
	public String getSheshishebei() {
		return sheshishebei;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
				
	
	/**
	 * 设置：场地规约
	 */
	 
	public void setChangdiguiyue(String changdiguiyue) {
		this.changdiguiyue = changdiguiyue;
	}
	
	/**
	 * 获取：场地规约
	 */
	public String getChangdiguiyue() {
		return changdiguiyue;
	}
				
	
	/**
	 * 设置：场地详情
	 */
	 
	public void setChangdixiangqing(String changdixiangqing) {
		this.changdixiangqing = changdixiangqing;
	}
	
	/**
	 * 获取：场地详情
	 */
	public String getChangdixiangqing() {
		return changdixiangqing;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
