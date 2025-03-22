package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GangweigongzuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GangweigongzuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GangweigongzuoView;


/**
 * 岗位工作
 *
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public interface GangweigongzuoService extends IService<GangweigongzuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweigongzuoVO> selectListVO(Wrapper<GangweigongzuoEntity> wrapper);
   	
   	GangweigongzuoVO selectVO(@Param("ew") Wrapper<GangweigongzuoEntity> wrapper);
   	
   	List<GangweigongzuoView> selectListView(Wrapper<GangweigongzuoEntity> wrapper);
   	
   	GangweigongzuoView selectView(@Param("ew") Wrapper<GangweigongzuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweigongzuoEntity> wrapper);
   	
}

