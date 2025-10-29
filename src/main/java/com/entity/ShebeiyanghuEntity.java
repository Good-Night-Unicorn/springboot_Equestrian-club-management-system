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
 * 设备养护
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
@TableName("shebeiyanghu")
public class ShebeiyanghuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShebeiyanghuEntity() {
		
	}
	
	public ShebeiyanghuEntity(T t) {
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
	 * 设备编号
	 */
					
	private String shebeibianhao;
	
	/**
	 * 设备名称
	 */
					
	private String shebeimingcheng;
	
	/**
	 * 设备类型
	 */
					
	private String shebeileixing;
	
	/**
	 * 养护图片
	 */
					
	private String yanghutupian;
	
	/**
	 * 养护数量
	 */
					
	private Integer yanghushuliang;
	
	/**
	 * 设备型号
	 */
					
	private String shebeixinghao;
	
	/**
	 * 养护记录
	 */
					
	private String yanghujilu;
	
	/**
	 * 养护时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date yanghushijian;
	
	/**
	 * 马房账号
	 */
					
	private String mafangzhanghao;
	
	/**
	 * 马房姓名
	 */
					
	private String mafangxingming;
	
	
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
	 * 设置：设备编号
	 */
	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}
	/**
	 * 获取：设备编号
	 */
	public String getShebeibianhao() {
		return shebeibianhao;
	}
	/**
	 * 设置：设备名称
	 */
	public void setShebeimingcheng(String shebeimingcheng) {
		this.shebeimingcheng = shebeimingcheng;
	}
	/**
	 * 获取：设备名称
	 */
	public String getShebeimingcheng() {
		return shebeimingcheng;
	}
	/**
	 * 设置：设备类型
	 */
	public void setShebeileixing(String shebeileixing) {
		this.shebeileixing = shebeileixing;
	}
	/**
	 * 获取：设备类型
	 */
	public String getShebeileixing() {
		return shebeileixing;
	}
	/**
	 * 设置：养护图片
	 */
	public void setYanghutupian(String yanghutupian) {
		this.yanghutupian = yanghutupian;
	}
	/**
	 * 获取：养护图片
	 */
	public String getYanghutupian() {
		return yanghutupian;
	}
	/**
	 * 设置：养护数量
	 */
	public void setYanghushuliang(Integer yanghushuliang) {
		this.yanghushuliang = yanghushuliang;
	}
	/**
	 * 获取：养护数量
	 */
	public Integer getYanghushuliang() {
		return yanghushuliang;
	}
	/**
	 * 设置：设备型号
	 */
	public void setShebeixinghao(String shebeixinghao) {
		this.shebeixinghao = shebeixinghao;
	}
	/**
	 * 获取：设备型号
	 */
	public String getShebeixinghao() {
		return shebeixinghao;
	}
	/**
	 * 设置：养护记录
	 */
	public void setYanghujilu(String yanghujilu) {
		this.yanghujilu = yanghujilu;
	}
	/**
	 * 获取：养护记录
	 */
	public String getYanghujilu() {
		return yanghujilu;
	}
	/**
	 * 设置：养护时间
	 */
	public void setYanghushijian(Date yanghushijian) {
		this.yanghushijian = yanghushijian;
	}
	/**
	 * 获取：养护时间
	 */
	public Date getYanghushijian() {
		return yanghushijian;
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
