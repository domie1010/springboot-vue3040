package com.yjkj.framework.rbac.real.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.real.model.Real;

public interface RealService {

	public Pager informationLoad(Pager pager,Real Real,HttpSession session) throws Exception;
	
	public List<Real> informationLoadAll(Real Real) throws Exception;
	
	public Integer count(Real Real) throws Exception;
	
	public Real informationLoadOne(Real Real) throws Exception;
	
	public void informationDelete(Real Real) throws Exception;
	
	public void informationAdd(Real Real) throws Exception;
	
	public void informationUpade(Real Real) throws Exception;
	
}
