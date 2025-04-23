package com.yjkj.framework.rbac.act.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.act.model.Act;

public interface ActDao {

	public List<Act> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Act> informationLoadAll(Act Act) throws Exception;
	
	public Integer count(Act Act) throws Exception;
	
	public Act informationLoadOne(Act Act) throws Exception;
	
	public void informationDelete(Act Act) throws Exception;
	
	public void informationAdd(Act Act) throws Exception;
	
	public void informationUpdate(Act Act) throws Exception;
	
}
