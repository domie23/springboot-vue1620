package com.dao;

import com.entity.LaoshikaoqinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LaoshikaoqinVO;
import com.entity.view.LaoshikaoqinView;


/**
 * 老师考勤
 * 
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public interface LaoshikaoqinDao extends BaseMapper<LaoshikaoqinEntity> {
	
	List<LaoshikaoqinVO> selectListVO(@Param("ew") Wrapper<LaoshikaoqinEntity> wrapper);
	
	LaoshikaoqinVO selectVO(@Param("ew") Wrapper<LaoshikaoqinEntity> wrapper);
	
	List<LaoshikaoqinView> selectListView(@Param("ew") Wrapper<LaoshikaoqinEntity> wrapper);

	List<LaoshikaoqinView> selectListView(Pagination page,@Param("ew") Wrapper<LaoshikaoqinEntity> wrapper);
	
	LaoshikaoqinView selectView(@Param("ew") Wrapper<LaoshikaoqinEntity> wrapper);
	
}
