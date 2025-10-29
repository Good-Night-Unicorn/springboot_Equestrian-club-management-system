package com.entity.model;

import com.entity.JifenduihuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 积分兑换
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-25 10:53:17
 */
public class JifenduihuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品分类
	 */
	
	private String shangpinfenlei;
		
	/**
	 * 商品图片
	 */
	
	private String shangpintupian;
		
	/**
	 * 兑换数量
	 */
	
	private Integer shangpinshuliang;
		
	/**
	 * 所需积分
	 */
	
	private Double suoxujifen;
		
	/**
	 * 合计积分
	 */
	
	private Double jifen;
		
	/**
	 * 兑换时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date duihuanshijian;
		
	/**
	 * 会员账号
	 */
	
	private String huiyuanzhanghao;
		
	/**
	 * 会员姓名
	 */
	
	private String huiyuanxingming;
		
	/**
	 * 会员积分
	 */
	
	private Double huiyuanjifen;
				
	
	/**
	 * 设置：商品分类
	 */
	 
	public void setShangpinfenlei(String shangpinfenlei) {
		this.shangpinfenlei = shangpinfenlei;
	}
	
	/**
	 * 获取：商品分类
	 */
	public String getShangpinfenlei() {
		return shangpinfenlei;
	}
				
	
	/**
	 * 设置：商品图片
	 */
	 
	public void setShangpintupian(String shangpintupian) {
		this.shangpintupian = shangpintupian;
	}
	
	/**
	 * 获取：商品图片
	 */
	public String getShangpintupian() {
		return shangpintupian;
	}
				
	
	/**
	 * 设置：兑换数量
	 */
	 
	public void setShangpinshuliang(Integer shangpinshuliang) {
		this.shangpinshuliang = shangpinshuliang;
	}
	
	/**
	 * 获取：兑换数量
	 */
	public Integer getShangpinshuliang() {
		return shangpinshuliang;
	}
				
	
	/**
	 * 设置：所需积分
	 */
	 
	public void setSuoxujifen(Double suoxujifen) {
		this.suoxujifen = suoxujifen;
	}
	
	/**
	 * 获取：所需积分
	 */
	public Double getSuoxujifen() {
		return suoxujifen;
	}
				
	
	/**
	 * 设置：合计积分
	 */
	 
	public void setJifen(Double jifen) {
		this.jifen = jifen;
	}
	
	/**
	 * 获取：合计积分
	 */
	public Double getJifen() {
		return jifen;
	}
				
	
	/**
	 * 设置：兑换时间
	 */
	 
	public void setDuihuanshijian(Date duihuanshijian) {
		this.duihuanshijian = duihuanshijian;
	}
	
	/**
	 * 获取：兑换时间
	 */
	public Date getDuihuanshijian() {
		return duihuanshijian;
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
	 * 设置：会员积分
	 */
	 
	public void setHuiyuanjifen(Double huiyuanjifen) {
		this.huiyuanjifen = huiyuanjifen;
	}
	
	/**
	 * 获取：会员积分
	 */
	public Double getHuiyuanjifen() {
		return huiyuanjifen;
	}
			
}
