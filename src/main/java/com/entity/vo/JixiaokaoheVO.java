package com.entity.vo;

import com.entity.JixiaokaoheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 绩效考核
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
public class JixiaokaoheVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 教练姓名
	 */
	
	private String jiaolianxingming;
		
	/**
	 * 绩效月份
	 */
	
	private String jixiaoyuefen;
		
	/**
	 * 教练考勤
	 */
	
	private Integer jiaoliankaoqin;
		
	/**
	 * 工作态度
	 */
	
	private Integer gongzuotaidu;
		
	/**
	 * 业务技能
	 */
	
	private Integer yewujineng;
		
	/**
	 * 工作绩效
	 */
	
	private Integer gongzuojixiao;
		
	/**
	 * 总得分
	 */
	
	private Integer zongdefen;
		
	/**
	 * 评价等级
	 */
	
	private String pingjiadengji;
		
	/**
	 * 点评
	 */
	
	private String dianping;
		
	/**
	 * 图片
	 */
	
	private String tupian;
				
	
	/**
	 * 设置：教练姓名
	 */
	 
	public void setJiaolianxingming(String jiaolianxingming) {
		this.jiaolianxingming = jiaolianxingming;
	}
	
	/**
	 * 获取：教练姓名
	 */
	public String getJiaolianxingming() {
		return jiaolianxingming;
	}
				
	
	/**
	 * 设置：绩效月份
	 */
	 
	public void setJixiaoyuefen(String jixiaoyuefen) {
		this.jixiaoyuefen = jixiaoyuefen;
	}
	
	/**
	 * 获取：绩效月份
	 */
	public String getJixiaoyuefen() {
		return jixiaoyuefen;
	}
				
	
	/**
	 * 设置：教练考勤
	 */
	 
	public void setJiaoliankaoqin(Integer jiaoliankaoqin) {
		this.jiaoliankaoqin = jiaoliankaoqin;
	}
	
	/**
	 * 获取：教练考勤
	 */
	public Integer getJiaoliankaoqin() {
		return jiaoliankaoqin;
	}
				
	
	/**
	 * 设置：工作态度
	 */
	 
	public void setGongzuotaidu(Integer gongzuotaidu) {
		this.gongzuotaidu = gongzuotaidu;
	}
	
	/**
	 * 获取：工作态度
	 */
	public Integer getGongzuotaidu() {
		return gongzuotaidu;
	}
				
	
	/**
	 * 设置：业务技能
	 */
	 
	public void setYewujineng(Integer yewujineng) {
		this.yewujineng = yewujineng;
	}
	
	/**
	 * 获取：业务技能
	 */
	public Integer getYewujineng() {
		return yewujineng;
	}
				
	
	/**
	 * 设置：工作绩效
	 */
	 
	public void setGongzuojixiao(Integer gongzuojixiao) {
		this.gongzuojixiao = gongzuojixiao;
	}
	
	/**
	 * 获取：工作绩效
	 */
	public Integer getGongzuojixiao() {
		return gongzuojixiao;
	}
				
	
	/**
	 * 设置：总得分
	 */
	 
	public void setZongdefen(Integer zongdefen) {
		this.zongdefen = zongdefen;
	}
	
	/**
	 * 获取：总得分
	 */
	public Integer getZongdefen() {
		return zongdefen;
	}
				
	
	/**
	 * 设置：评价等级
	 */
	 
	public void setPingjiadengji(String pingjiadengji) {
		this.pingjiadengji = pingjiadengji;
	}
	
	/**
	 * 获取：评价等级
	 */
	public String getPingjiadengji() {
		return pingjiadengji;
	}
				
	
	/**
	 * 设置：点评
	 */
	 
	public void setDianping(String dianping) {
		this.dianping = dianping;
	}
	
	/**
	 * 获取：点评
	 */
	public String getDianping() {
		return dianping;
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
			
}
