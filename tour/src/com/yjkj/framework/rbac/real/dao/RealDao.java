package com.yjkj.framework.rbac.real.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.real.model.Real;

public interface RealDao {

	public List<Real> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Real> informationLoadAll(Real Real) throws Exception;
	
	public Integer count(Real Real) throws Exception;
	
	public Real informationLoadOne(Real Real) throws Exception;
	
	public void informationDelete(Real Real) throws Exception;
	
	public void informationAdd(Real Real) throws Exception;
	
	public void informationUpdate(Real Real) throws Exception;
	
}
