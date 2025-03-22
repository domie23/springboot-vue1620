package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengkaoqinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengkaoqinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengkaoqinView;


/**
 * 学生考勤
 *
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public interface XueshengkaoqinService extends IService<XueshengkaoqinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengkaoqinVO> selectListVO(Wrapper<XueshengkaoqinEntity> wrapper);
   	
   	XueshengkaoqinVO selectVO(@Param("ew") Wrapper<XueshengkaoqinEntity> wrapper);
   	
   	List<XueshengkaoqinView> selectListView(Wrapper<XueshengkaoqinEntity> wrapper);
   	
   	XueshengkaoqinView selectView(@Param("ew") Wrapper<XueshengkaoqinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengkaoqinEntity> wrapper);
   	
}

