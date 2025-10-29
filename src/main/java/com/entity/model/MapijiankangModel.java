package com.entity.model;

import com.entity.MapijiankangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 马匹健康
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public class MapijiankangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 马匹种类
	 */
	
	private String mapizhonglei;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 马匹编号
	 */
	
	private String mapibianhao;
		
	/**
	 * 马匹性别
	 */
	
	private String mapixingbie;
		
	/**
	 * 马匹年龄
	 */
	
	private Integer mapinianling;
		
	/**
	 * 记录时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jilushijian;
		
	/**
	 * 健康类型
	 */
	
	private String jiankangleixing;
		
	/**
	 * 记录详情
	 */
	
	private String jiluxiangqing;
		
	/**
	 * 马房账号
	 */
	
	private String mafangzhanghao;
		
	/**
	 * 马房姓名
	 */
	
	private String mafangxingming;
				
	
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
	 * 设置：马匹年龄
	 */
	 
	public void setMapinianling(Integer mapinianling) {
		this.mapinianling = mapinianling;
	}
	
	/**
	 * 获取：马匹年龄
	 */
	public Integer getMapinianling() {
		return mapinianling;
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
	 * 设置：健康类型
	 */
	 
	public void setJiankangleixing(String jiankangleixing) {
		this.jiankangleixing = jiankangleixing;
	}
	
	/**
	 * 获取：健康类型
	 */
	public String getJiankangleixing() {
		return jiankangleixing;
	}
				
	
	/**
	 * 设置：记录详情
	 */
	 
	public void setJiluxiangqing(String jiluxiangqing) {
		this.jiluxiangqing = jiluxiangqing;
	}
	
	/**
	 * 获取：记录详情
	 */
	public String getJiluxiangqing() {
		return jiluxiangqing;
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
