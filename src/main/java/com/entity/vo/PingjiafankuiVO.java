package com.entity.vo;

import com.entity.PingjiafankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 评价反馈
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public class PingjiafankuiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 反馈标题
	 */
	
	private String fankuibiaoti;
		
	/**
	 * 反馈图片
	 */
	
	private String fankuitupian;
		
	/**
	 * 教练账号
	 */
	
	private String jiaolianzhanghao;
		
	/**
	 * 教练姓名
	 */
	
	private String jiaolianxingming;
		
	/**
	 * 会员账号
	 */
	
	private String huiyuanzhanghao;
		
	/**
	 * 会员姓名
	 */
	
	private String huiyuanxingming;
		
	/**
	 * 反馈时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fankuishijian;
		
	/**
	 * 评价打分
	 */
	
	private String pingjiadafen;
		
	/**
	 * 评价结果
	 */
	
	private String pingjiajieguo;
		
	/**
	 * 反馈内容
	 */
	
	private String fankuineirong;
				
	
	/**
	 * 设置：反馈标题
	 */
	 
	public void setFankuibiaoti(String fankuibiaoti) {
		this.fankuibiaoti = fankuibiaoti;
	}
	
	/**
	 * 获取：反馈标题
	 */
	public String getFankuibiaoti() {
		return fankuibiaoti;
	}
				
	
	/**
	 * 设置：反馈图片
	 */
	 
	public void setFankuitupian(String fankuitupian) {
		this.fankuitupian = fankuitupian;
	}
	
	/**
	 * 获取：反馈图片
	 */
	public String getFankuitupian() {
		return fankuitupian;
	}
				
	
	/**
	 * 设置：教练账号
	 */
	 
	public void setJiaolianzhanghao(String jiaolianzhanghao) {
		this.jiaolianzhanghao = jiaolianzhanghao;
	}
	
	/**
	 * 获取：教练账号
	 */
	public String getJiaolianzhanghao() {
		return jiaolianzhanghao;
	}
				
	
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
	 * 设置：会员账号
	 */
	 
	public void setHuiyuanzhanghao(String huiyuanzhanghao) {
		this.huiyuanzhanghao = huiyuanzhanghao;
	}
	
	/**
	 * 获取：会员账号
	 */
	public String getHuiyuanzhanghao() {
		return huiyuanzhanghao;
	}
				
	
	/**
	 * 设置：会员姓名
	 */
	 
	public void setHuiyuanxingming(String huiyuanxingming) {
		this.huiyuanxingming = huiyuanxingming;
	}
	
	/**
	 * 获取：会员姓名
	 */
	public String getHuiyuanxingming() {
		return huiyuanxingming;
	}
				
	
	/**
	 * 设置：反馈时间
	 */
	 
	public void setFankuishijian(Date fankuishijian) {
		this.fankuishijian = fankuishijian;
	}
	
	/**
	 * 获取：反馈时间
	 */
	public Date getFankuishijian() {
		return fankuishijian;
	}
				
	
	/**
	 * 设置：评价打分
	 */
	 
	public void setPingjiadafen(String pingjiadafen) {
		this.pingjiadafen = pingjiadafen;
	}
	
	/**
	 * 获取：评价打分
	 */
	public String getPingjiadafen() {
		return pingjiadafen;
	}
				
	
	/**
	 * 设置：评价结果
	 */
	 
	public void setPingjiajieguo(String pingjiajieguo) {
		this.pingjiajieguo = pingjiajieguo;
	}
	
	/**
	 * 获取：评价结果
	 */
	public String getPingjiajieguo() {
		return pingjiajieguo;
	}
				
	
	/**
	 * 设置：反馈内容
	 */
	 
	public void setFankuineirong(String fankuineirong) {
		this.fankuineirong = fankuineirong;
	}
	
	/**
	 * 获取：反馈内容
	 */
	public String getFankuineirong() {
		return fankuineirong;
	}
			
}
