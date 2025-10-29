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
 * 马匹信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:15
 */
@TableName("mapixinxi")
public class MapixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MapixinxiEntity() {
		
	}
	
	public MapixinxiEntity(T t) {
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
