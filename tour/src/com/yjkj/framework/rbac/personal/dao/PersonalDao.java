package com.yjkj.framework.rbac.personal.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.personal.model.Personal;

public interface PersonalDao {

	public List<Personal> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Personal> informationLoadAll(Personal Personal) throws Exception;
	
	public Integer count(Personal Personal) throws Exception;
	
	public Personal informationLoadOne(Personal Personal) throws Exception;
	
	public void informationDelete(Personal Personal) throws Exception;
	
	public void informationAdd(Personal Personal) throws Exception;
	
	public void informationUpdate(Personal Personal) throws Exception;
	
}
