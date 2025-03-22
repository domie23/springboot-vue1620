package com.dao;

import com.entity.ShenqingqingkuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenqingqingkuangVO;
import com.entity.view.ShenqingqingkuangView;


/**
 * 申请情况
 * 
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public interface ShenqingqingkuangDao extends BaseMapper<ShenqingqingkuangEntity> {
	
	List<ShenqingqingkuangVO> selectListVO(@Param("ew") Wrapper<ShenqingqingkuangEntity> wrapper);
	
	ShenqingqingkuangVO selectVO(@Param("ew") Wrapper<ShenqingqingkuangEntity> wrapper);
	
	List<ShenqingqingkuangView> selectListView(@Param("ew") Wrapper<ShenqingqingkuangEntity> wrapper);

	List<ShenqingqingkuangView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingqingkuangEntity> wrapper);
	
	ShenqingqingkuangView selectView(@Param("ew") Wrapper<ShenqingqingkuangEntity> wrapper);
	
}
