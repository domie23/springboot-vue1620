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


import com.dao.LaoshikaoqinDao;
import com.entity.LaoshikaoqinEntity;
import com.service.LaoshikaoqinService;
import com.entity.vo.LaoshikaoqinVO;
import com.entity.view.LaoshikaoqinView;

@Service("laoshikaoqinService")
public class LaoshikaoqinServiceImpl extends ServiceImpl<LaoshikaoqinDao, LaoshikaoqinEntity> implements LaoshikaoqinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LaoshikaoqinEntity> page = this.selectPage(
                new Query<LaoshikaoqinEntity>(params).getPage(),
                new EntityWrapper<LaoshikaoqinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LaoshikaoqinEntity> wrapper) {
		  Page<LaoshikaoqinView> page =new Query<LaoshikaoqinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LaoshikaoqinVO> selectListVO(Wrapper<LaoshikaoqinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LaoshikaoqinVO selectVO(Wrapper<LaoshikaoqinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LaoshikaoqinView> selectListView(Wrapper<LaoshikaoqinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LaoshikaoqinView selectView(Wrapper<LaoshikaoqinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
