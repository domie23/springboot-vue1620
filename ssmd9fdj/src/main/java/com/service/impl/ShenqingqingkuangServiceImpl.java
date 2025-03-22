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


import com.dao.ShenqingqingkuangDao;
import com.entity.ShenqingqingkuangEntity;
import com.service.ShenqingqingkuangService;
import com.entity.vo.ShenqingqingkuangVO;
import com.entity.view.ShenqingqingkuangView;

@Service("shenqingqingkuangService")
public class ShenqingqingkuangServiceImpl extends ServiceImpl<ShenqingqingkuangDao, ShenqingqingkuangEntity> implements ShenqingqingkuangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingqingkuangEntity> page = this.selectPage(
                new Query<ShenqingqingkuangEntity>(params).getPage(),
                new EntityWrapper<ShenqingqingkuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingqingkuangEntity> wrapper) {
		  Page<ShenqingqingkuangView> page =new Query<ShenqingqingkuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenqingqingkuangVO> selectListVO(Wrapper<ShenqingqingkuangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingqingkuangVO selectVO(Wrapper<ShenqingqingkuangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingqingkuangView> selectListView(Wrapper<ShenqingqingkuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingqingkuangView selectView(Wrapper<ShenqingqingkuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
