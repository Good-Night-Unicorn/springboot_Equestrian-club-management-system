package com.entity.vo;

import com.entity.ChangdiyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 场地预订
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public class ChangdiyudingVO  implements Serializable {
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
	 * 预订时段
	 */
	
	private String keyueshiduan;
		
	/**
	 * 预订备注
	 */
	
	private String yudingbeizhu;
		
	/**
	 * 预订时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yudingshijian;
		
	/**
	 * 预订人员
	 */
	
	private String yudingrenyuan;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
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
	 * 设置：预订时段
	 */
	 
	public void setKeyueshiduan(String keyueshiduan) {
		this.keyueshiduan = keyueshiduan;
	}
	
	/**
	 * 获取：预订时段
	 */
	public String getKeyueshiduan() {
		return keyueshiduan;
	}
				
	
	/**
	 * 设置：预订备注
	 */
	 
	public void setYudingbeizhu(String yudingbeizhu) {
		this.yudingbeizhu = yudingbeizhu;
	}
	
	/**
	 * 获取：预订备注
	 */
	public String getYudingbeizhu() {
		return yudingbeizhu;
	}
				
	
	/**
	 * 设置：预订时间
	 */
	 
	public void setYudingshijian(Date yudingshijian) {
		this.yudingshijian = yudingshijian;
	}
	
	/**
	 * 获取：预订时间
	 */
	public Date getYudingshijian() {
		return yudingshijian;
	}
				
	
	/**
	 * 设置：预订人员
	 */
	 
	public void setYudingrenyuan(String yudingrenyuan) {
		this.yudingrenyuan = yudingrenyuan;
	}
	
	/**
	 * 获取：预订人员
	 */
	public String getYudingrenyuan() {
		return yudingrenyuan;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
