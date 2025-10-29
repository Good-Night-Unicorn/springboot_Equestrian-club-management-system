package com.entity.vo;

import com.entity.ShebeiyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 设备预订
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public class ShebeiyudingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 设备名称
	 */
	
	private String shebeimingcheng;
		
	/**
	 * 设备类型
	 */
	
	private String shebeileixing;
		
	/**
	 * 设备图片
	 */
	
	private String shebeitupian;
		
	/**
	 * 预订数量
	 */
	
	private Integer shebeishuliang;
		
	/**
	 * 设备型号
	 */
	
	private String shebeixinghao;
		
	/**
	 * 预订时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yudingshijian;
		
	/**
	 * 预订备注
	 */
	
	private String yudingbeizhu;
		
	/**
	 * 预订人员
	 */
	
	private String yudingrenyuan;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
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
	 * 设置：设备图片
	 */
	 
	public void setShebeitupian(String shebeitupian) {
		this.shebeitupian = shebeitupian;
	}
	
	/**
	 * 获取：设备图片
	 */
	public String getShebeitupian() {
		return shebeitupian;
	}
				
	
	/**
	 * 设置：预订数量
	 */
	 
	public void setShebeishuliang(Integer shebeishuliang) {
		this.shebeishuliang = shebeishuliang;
	}
	
	/**
	 * 获取：预订数量
	 */
	public Integer getShebeishuliang() {
		return shebeishuliang;
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
