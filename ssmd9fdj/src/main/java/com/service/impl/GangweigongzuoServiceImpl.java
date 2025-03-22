package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GangweigongzuoDao;
import com.entity.GangweigongzuoEntity;
import com.service.GangweigongzuoService;
import com.entity.vo.GangweigongzuoVO;
import com.entity.view.GangweigongzuoView;

@Service("gangweigongzuoService")
public class GangweigongzuoServiceImpl extends ServiceImpl<GangweigongzuoDao, GangweigongzuoEntity> implements GangweigongzuoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweigongzuoEntity> page = this.selectPage(
                new Query<GangweigongzuoEntity>(params).getPage(),
                new EntityWrapper<GangweigongzuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweigongzuoEntity> wrapper) {
		  Page<GangweigongzuoView> page =new Query<GangweigongzuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GangweigongzuoVO> selectListVO(Wrapper<GangweigongzuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GangweigongzuoVO selectVO(Wrapper<GangweigongzuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GangweigongzuoView> selectListView(Wrapper<GangweigongzuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweigongzuoView selectView(Wrapper<GangweigongzuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
