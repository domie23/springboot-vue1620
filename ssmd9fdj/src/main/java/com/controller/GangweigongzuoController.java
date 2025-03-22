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

import com.entity.GangweigongzuoEntity;
import com.entity.view.GangweigongzuoView;

import com.service.GangweigongzuoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 岗位工作
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-22 12:03:20
 */
@RestController
@RequestMapping("/gangweigongzuo")
public class GangweigongzuoController {
    @Autowired
    private GangweigongzuoService gangweigongzuoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweigongzuoEntity gangweigongzuo, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("laoshi")) {
			gangweigongzuo.setLaoshizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GangweigongzuoEntity> ew = new EntityWrapper<GangweigongzuoEntity>();
		PageUtils page = gangweigongzuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweigongzuo), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweigongzuoEntity gangweigongzuo, HttpServletRequest request){
        EntityWrapper<GangweigongzuoEntity> ew = new EntityWrapper<GangweigongzuoEntity>();
		PageUtils page = gangweigongzuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweigongzuo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweigongzuoEntity gangweigongzuo){
       	EntityWrapper<GangweigongzuoEntity> ew = new EntityWrapper<GangweigongzuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangweigongzuo, "gangweigongzuo")); 
        return R.ok().put("data", gangweigongzuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweigongzuoEntity gangweigongzuo){
        EntityWrapper< GangweigongzuoEntity> ew = new EntityWrapper< GangweigongzuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangweigongzuo, "gangweigongzuo")); 
		GangweigongzuoView gangweigongzuoView =  gangweigongzuoService.selectView(ew);
		return R.ok("查询岗位工作成功").put("data", gangweigongzuoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GangweigongzuoEntity gangweigongzuo = gangweigongzuoService.selectById(id);
		gangweigongzuo.setClicktime(new Date());
		gangweigongzuoService.updateById(gangweigongzuo);
        return R.ok().put("data", gangweigongzuo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GangweigongzuoEntity gangweigongzuo = gangweigongzuoService.selectById(id);
		gangweigongzuo.setClicktime(new Date());
		gangweigongzuoService.updateById(gangweigongzuo);
        return R.ok().put("data", gangweigongzuo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweigongzuoEntity gangweigongzuo, HttpServletRequest request){
    	gangweigongzuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweigongzuo);

        gangweigongzuoService.insert(gangweigongzuo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GangweigongzuoEntity gangweigongzuo, HttpServletRequest request){
    	gangweigongzuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweigongzuo);

        gangweigongzuoService.insert(gangweigongzuo);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GangweigongzuoEntity gangweigongzuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweigongzuo);
        gangweigongzuoService.updateById(gangweigongzuo);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweigongzuoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GangweigongzuoEntity> wrapper = new EntityWrapper<GangweigongzuoEntity>();
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

		int count = gangweigongzuoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GangweigongzuoEntity gangweigongzuo, HttpServletRequest request,String pre){
        EntityWrapper<GangweigongzuoEntity> ew = new EntityWrapper<GangweigongzuoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        
        params.put("order", "desc");
		PageUtils page = gangweigongzuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweigongzuo), params), params));
        return R.ok().put("data", page);
    }


}
