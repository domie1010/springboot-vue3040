package com.yjkj.framework.rbac.real.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.real.model.Real;
import com.yjkj.framework.rbac.real.service.inte.RealService;
@Service
public class RealServiceImpl extends BaseService implements RealService {

	
	@Override
	public Pager informationLoad(Pager pager,Real Real,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("real", Real);
		List<Real> list = this.realDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Real));
		return pager;
	}

	@Override
	public List<Real> informationLoadAll(Real Real) throws Exception {
		List<Real> list = this.realDao.informationLoadAll(Real);
		return list;
	}
	

	@Override
	public Integer count(Real Real) throws Exception {
		Integer count = this.realDao.count(Real);
		return count;
	}

	@Override
	public Real informationLoadOne(Real Real) throws Exception {
			Real = this.realDao.informationLoadOne(Real);
		return Real;
	}

	@Override
	public void informationDelete(Real Real) throws Exception {
			this.realDao.informationDelete(Real);

	}

	@Override
	public void informationAdd(Real Real) throws Exception {
			Real.setId(Regular.createId());
			Real.setCreatetime(CreatDate.getDate());
			this.realDao.informationAdd(Real);

	}

	@Override
	public void informationUpade(Real Real) throws Exception {
			this.realDao.informationUpdate(Real);

	}

}
