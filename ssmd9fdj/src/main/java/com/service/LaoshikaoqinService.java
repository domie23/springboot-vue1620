package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LaoshikaoqinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LaoshikaoqinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LaoshikaoqinView;


/**
 * 老师考勤
 *
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public interface LaoshikaoqinService extends IService<LaoshikaoqinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LaoshikaoqinVO> selectListVO(Wrapper<LaoshikaoqinEntity> wrapper);
   	
   	LaoshikaoqinVO selectVO(@Param("ew") Wrapper<LaoshikaoqinEntity> wrapper);
   	
   	List<LaoshikaoqinView> selectListView(Wrapper<LaoshikaoqinEntity> wrapper);
   	
   	LaoshikaoqinView selectView(@Param("ew") Wrapper<LaoshikaoqinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LaoshikaoqinEntity> wrapper);
   	
}

