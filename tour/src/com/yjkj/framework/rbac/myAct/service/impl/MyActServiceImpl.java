package com.yjkj.framework.rbac.myAct.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.myAct.model.MyAct;
import com.yjkj.framework.rbac.myAct.service.inte.MyActService;
@Service
public class MyActServiceImpl extends BaseService implements MyActService {

	
	@Override
	public Pager informationLoad(Pager pager,MyAct MyAct,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("myAct", MyAct);
		List<MyAct> list = this.myActDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(MyAct));
		return pager;
	}

	@Override
	public List<MyAct> informationLoadAll(MyAct MyAct) throws Exception {
		List<MyAct> list = this.myActDao.informationLoadAll(MyAct);
		return list;
	}
	

	@Override
	public Integer count(MyAct MyAct) throws Exception {
		Integer count = this.myActDao.count(MyAct);
		return count;
	}

	@Override
	public MyAct informationLoadOne(MyAct MyAct) throws Exception {
			MyAct = this.myActDao.informationLoadOne(MyAct);
		return MyAct;
	}

	@Override
	public void informationDelete(MyAct MyAct) throws Exception {
			this.myActDao.informationDelete(MyAct);

	}

	@Override
	public void informationAdd(MyAct MyAct) throws Exception {
			MyAct.setId(Regular.createId());
			MyAct.setCreatetime(CreatDate.getDate());
			this.myActDao.informationAdd(MyAct);

	}

	@Override
	public void informationUpade(MyAct MyAct) throws Exception {
			this.myActDao.informationUpdate(MyAct);

	}

}
