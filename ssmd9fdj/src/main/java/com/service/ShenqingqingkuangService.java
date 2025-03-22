package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenqingqingkuangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenqingqingkuangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingqingkuangView;


/**
 * 申请情况
 *
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public interface ShenqingqingkuangService extends IService<ShenqingqingkuangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingqingkuangVO> selectListVO(Wrapper<ShenqingqingkuangEntity> wrapper);
   	
   	ShenqingqingkuangVO selectVO(@Param("ew") Wrapper<ShenqingqingkuangEntity> wrapper);
   	
   	List<ShenqingqingkuangView> selectListView(Wrapper<ShenqingqingkuangEntity> wrapper);
   	
   	ShenqingqingkuangView selectView(@Param("ew") Wrapper<ShenqingqingkuangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingqingkuangEntity> wrapper);
   	
}

