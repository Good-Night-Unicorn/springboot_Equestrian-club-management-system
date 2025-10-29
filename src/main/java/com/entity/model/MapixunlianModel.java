package com.entity.model;

import com.entity.MapixunlianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 马匹训练
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public class MapixunlianModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 马匹种类
	 */
	
	private String mapizhonglei;
		
	/**
	 * 马匹编号
	 */
	
	private String mapibianhao;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 马匹性别
	 */
	
	private String mapixingbie;
		
	/**
	 * 教练账号
	 */
	
	private String jiaolianzhanghao;
		
	/**
	 * 教练姓名
	 */
	
	private String jiaolianxingming;
		
	/**
	 * 记录时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jilushijian;
		
	/**
	 * 训练结果
	 */
	
	private String xunlianjieguo;
		
	/**
	 * 训练详情
	 */
	
	private String xunlianxiangqing;
				
	
	/**
	 * 设置：马匹种类
	 */
	 
	public void setMapizhonglei(String mapizhonglei) {
		this.mapizhonglei = mapizhonglei;
	}
	
	/**
	 * 获取：马匹种类
	 */
	public String getMapizhonglei() {
		return mapizhonglei;
	}
				
	
	/**
	 * 设置：马匹编号
	 */
	 
	public void setMapibianhao(String mapibianhao) {
		this.mapibianhao = mapibianhao;
	}
	
	/**
	 * 获取：马匹编号
	 */
	public String getMapibianhao() {
		return mapibianhao;
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
	 * 设置：马匹性别
	 */
	 
	public void setMapixingbie(String mapixingbie) {
		this.mapixingbie = mapixingbie;
	}
	
	/**
	 * 获取：马匹性别
	 */
	public String getMapixingbie() {
		return mapixingbie;
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
	 * 设置：记录时间
	 */
	 
	public void setJilushijian(Date jilushijian) {
		this.jilushijian = jilushijian;
	}
	
	/**
	 * 获取：记录时间
	 */
	public Date getJilushijian() {
		return jilushijian;
	}
				
	
	/**
	 * 设置：训练结果
	 */
	 
	public void setXunlianjieguo(String xunlianjieguo) {
		this.xunlianjieguo = xunlianjieguo;
	}
	
	/**
	 * 获取：训练结果
	 */
	public String getXunlianjieguo() {
		return xunlianjieguo;
	}
				
	
	/**
	 * 设置：训练详情
	 */
	 
	public void setXunlianxiangqing(String xunlianxiangqing) {
		this.xunlianxiangqing = xunlianxiangqing;
	}
	
	/**
	 * 获取：训练详情
	 */
	public String getXunlianxiangqing() {
		return xunlianxiangqing;
	}
			
}
