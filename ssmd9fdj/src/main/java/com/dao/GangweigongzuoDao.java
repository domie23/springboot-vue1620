package com.dao;

import com.entity.GangweigongzuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GangweigongzuoVO;
import com.entity.view.GangweigongzuoView;


/**
 * 岗位工作
 * 
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
public interface GangweigongzuoDao extends BaseMapper<GangweigongzuoEntity> {
	
	List<GangweigongzuoVO> selectListVO(@Param("ew") Wrapper<GangweigongzuoEntity> wrapper);
	
	GangweigongzuoVO selectVO(@Param("ew") Wrapper<GangweigongzuoEntity> wrapper);
	
	List<GangweigongzuoView> selectListView(@Param("ew") Wrapper<GangweigongzuoEntity> wrapper);

	List<GangweigongzuoView> selectListView(Pagination page,@Param("ew") Wrapper<GangweigongzuoEntity> wrapper);
	
	GangweigongzuoView selectView(@Param("ew") Wrapper<GangweigongzuoEntity> wrapper);
	
}
