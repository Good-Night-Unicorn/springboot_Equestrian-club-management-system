package com.entity.model;

import com.entity.ShebeiyanghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 设备养护
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-12-25 10:53:16
 */
public class ShebeiyanghuModel  implements Serializable {
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
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
