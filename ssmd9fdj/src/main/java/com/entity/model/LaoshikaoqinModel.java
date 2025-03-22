package com.entity.model;

import com.entity.LaoshikaoqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 老师考勤
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public class LaoshikaoqinModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 考勤时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date kaoqinshijian;
		
	/**
	 * 老师账号
	 */
	
	private String laoshizhanghao;
		
	/**
	 * 老师姓名
	 */
	
	private String laoshixingming;
		
	/**
	 * 是否迟到
	 */
	
	private String shifouchidao;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
				
	
	/**
	 * 设置：考勤时间
	 */
	 
	public void setKaoqinshijian(Date kaoqinshijian) {
		this.kaoqinshijian = kaoqinshijian;
	}
	
	/**
	 * 获取：考勤时间
	 */
	public Date getKaoqinshijian() {
		return kaoqinshijian;
	}
				
	
	/**
	 * 设置：老师账号
	 */
	 
	public void setLaoshizhanghao(String laoshizhanghao) {
		this.laoshizhanghao = laoshizhanghao;
	}
	
	/**
	 * 获取：老师账号
	 */
	public String getLaoshizhanghao() {
		return laoshizhanghao;
	}
				
	
	/**
	 * 设置：老师姓名
	 */
	 
	public void setLaoshixingming(String laoshixingming) {
		this.laoshixingming = laoshixingming;
	}
	
	/**
	 * 获取：老师姓名
	 */
	public String getLaoshixingming() {
		return laoshixingming;
	}
				
	
	/**
	 * 设置：是否迟到
	 */
	 
	public void setShifouchidao(String shifouchidao) {
		this.shifouchidao = shifouchidao;
	}
	
	/**
	 * 获取：是否迟到
	 */
	public String getShifouchidao() {
		return shifouchidao;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
			
}
