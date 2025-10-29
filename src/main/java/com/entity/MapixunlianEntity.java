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
 * 马匹训练
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@TableName("mapixunlian")
public class MapixunlianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MapixunlianEntity() {
		
	}
	
	public MapixunlianEntity(T t) {
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
	 * 马匹名字
	 */
					
	private String mapimingzi;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 设置：马匹名字
	 */
	public void setMapimingzi(String mapimingzi) {
		this.mapimingzi = mapimingzi;
	}
	/**
	 * 获取：马匹名字
	 */
	public String getMapimingzi() {
		return mapimingzi;
	}
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
