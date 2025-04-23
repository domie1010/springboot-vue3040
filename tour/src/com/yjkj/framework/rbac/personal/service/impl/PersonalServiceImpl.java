package com.yjkj.framework.rbac.personal.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.personal.model.Personal;
import com.yjkj.framework.rbac.personal.service.inte.PersonalService;
@Service
public class PersonalServiceImpl extends BaseService implements PersonalService {

	
	@Override
	public Pager informationLoad(Pager pager,Personal Personal,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("personal", Personal);
		List<Personal> list = this.personalDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Personal));
		return pager;
	}

	@Override
	public List<Personal> informationLoadAll(Personal Personal) throws Exception {
		List<Personal> list = this.personalDao.informationLoadAll(Personal);
		return list;
	}
	

	@Override
	public Integer count(Personal Personal) throws Exception {
		Integer count = this.personalDao.count(Personal);
		return count;
	}

	@Override
	public Personal informationLoadOne(Personal Personal) throws Exception {
			Personal = this.personalDao.informationLoadOne(Personal);
		return Personal;
	}

	@Override
	public void informationDelete(Personal Personal) throws Exception {
			this.personalDao.informationDelete(Personal);

	}

	@Override
	public void informationAdd(Personal Personal) throws Exception {
			Personal.setId(Regular.createId());
			Personal.setCreatetime(CreatDate.getDate());
			this.personalDao.informationAdd(Personal);

	}

	@Override
	public void informationUpade(Personal Personal) throws Exception {
			this.personalDao.informationUpdate(Personal);

	}

}
