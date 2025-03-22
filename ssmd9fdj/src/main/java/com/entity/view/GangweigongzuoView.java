package com.entity.view;

import com.entity.GangweigongzuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 岗位工作
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
@TableName("gangweigongzuo")
public class GangweigongzuoView  extends GangweigongzuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GangweigongzuoView(){
	}
 
 	public GangweigongzuoView(GangweigongzuoEntity gangweigongzuoEntity){
 	try {
			BeanUtils.copyProperties(this, gangweigongzuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
