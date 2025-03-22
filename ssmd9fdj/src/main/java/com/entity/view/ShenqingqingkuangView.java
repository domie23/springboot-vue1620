package com.entity.view;

import com.entity.ShenqingqingkuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 申请情况
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
@TableName("shenqingqingkuang")
public class ShenqingqingkuangView  extends ShenqingqingkuangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingqingkuangView(){
	}
 
 	public ShenqingqingkuangView(ShenqingqingkuangEntity shenqingqingkuangEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingqingkuangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
