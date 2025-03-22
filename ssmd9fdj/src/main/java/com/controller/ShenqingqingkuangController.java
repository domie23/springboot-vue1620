package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShenqingqingkuangEntity;
import com.entity.view.ShenqingqingkuangView;

import com.service.ShenqingqingkuangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 申请情况
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
@RestController
@RequestMapping("/shenqingqingkuang")
public class ShenqingqingkuangController {
    @Autowired
    private ShenqingqingkuangService shenqingqingkuangService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingqingkuangEntity shenqingqingkuang, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoshi")) {
			shenqingqingkuang.setLaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			shenqingqingkuang.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingqingkuangEntity> ew = new EntityWrapper<ShenqingqingkuangEntity>();
		PageUtils page = shenqingqingkuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingqingkuang), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingqingkuangEntity shenqingqingkuang, HttpServletRequest request){
        EntityWrapper<ShenqingqingkuangEntity> ew = new EntityWrapper<ShenqingqingkuangEntity>();
		PageUtils page = shenqingqingkuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingqingkuang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingqingkuangEntity shenqingqingkuang){
       	EntityWrapper<ShenqingqingkuangEntity> ew = new EntityWrapper<ShenqingqingkuangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingqingkuang, "shenqingqingkuang")); 
        return R.ok().put("data", shenqingqingkuangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingqingkuangEntity shenqingqingkuang){
        EntityWrapper< ShenqingqingkuangEntity> ew = new EntityWrapper< ShenqingqingkuangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingqingkuang, "shenqingqingkuang")); 
		ShenqingqingkuangView shenqingqingkuangView =  shenqingqingkuangService.selectView(ew);
		return R.ok("查询申请情况成功").put("data", shenqingqingkuangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingqingkuangEntity shenqingqingkuang = shenqingqingkuangService.selectById(id);
        return R.ok().put("data", shenqingqingkuang);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingqingkuangEntity shenqingqingkuang = shenqingqingkuangService.selectById(id);
        return R.ok().put("data", shenqingqingkuang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingqingkuangEntity shenqingqingkuang, HttpServletRequest request){
    	shenqingqingkuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingqingkuang);

        shenqingqingkuangService.insert(shenqingqingkuang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingqingkuangEntity shenqingqingkuang, HttpServletRequest request){
    	shenqingqingkuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shenqingqingkuang);

        shenqingqingkuangService.insert(shenqingqingkuang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShenqingqingkuangEntity shenqingqingkuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingqingkuang);
        shenqingqingkuangService.updateById(shenqingqingkuang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenqingqingkuangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShenqingqingkuangEntity> wrapper = new EntityWrapper<ShenqingqingkuangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoshi")) {
			wrapper.eq("laoshizhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = shenqingqingkuangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
