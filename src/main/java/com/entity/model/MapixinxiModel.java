package com.entity.model;

import com.entity.MapixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 马匹信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
public class MapixinxiModel  implements Serializable {
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
	 * 身体状况
	 */
	
	private String shentizhuangkuang;
		
	/**
	 * 马匹年龄
	 */
	
	private Integer mapinianling;
		
	/**
	 * 是否接种
	 */
	
	private String shifoujiezhong;
		
	/**
	 * 马匹性情
	 */
	
	private String mapixingqing;
		
	/**
	 * 马匹爱好
	 */
	
	private String mapiaihao;
		
	/**
	 * 马匹详情
	 */
	
	private String mapixiangqing;
		
	/**
	 * 教练账号
	 */
	
	private String jiaolianzhanghao;
		
	/**
	 * 教练姓名
	 */
	
	private String jiaolianxingming;
				
	
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
	 * 设置：身体状况
	 */
	 
	public void setShentizhuangkuang(String shentizhuangkuang) {
		this.shentizhuangkuang = shentizhuangkuang;
	}
	
	/**
	 * 获取：身体状况
	 */
	public String getShentizhuangkuang() {
		return shentizhuangkuang;
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
	 * 设置：是否接种
	 */
	 
	public void setShifoujiezhong(String shifoujiezhong) {
		this.shifoujiezhong = shifoujiezhong;
	}
	
	/**
	 * 获取：是否接种
	 */
	public String getShifoujiezhong() {
		return shifoujiezhong;
	}
				
	
	/**
	 * 设置：马匹性情
	 */
	 
	public void setMapixingqing(String mapixingqing) {
		this.mapixingqing = mapixingqing;
	}
	
	/**
	 * 获取：马匹性情
	 */
	public String getMapixingqing() {
		return mapixingqing;
	}
				
	
	/**
	 * 设置：马匹爱好
	 */
	 
	public void setMapiaihao(String mapiaihao) {
		this.mapiaihao = mapiaihao;
	}
	
	/**
	 * 获取：马匹爱好
	 */
	public String getMapiaihao() {
		return mapiaihao;
	}
				
	
	/**
	 * 设置：马匹详情
	 */
	 
	public void setMapixiangqing(String mapixiangqing) {
		this.mapixiangqing = mapixiangqing;
	}
	
	/**
	 * 获取：马匹详情
	 */
	public String getMapixiangqing() {
		return mapixiangqing;
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
			
}
