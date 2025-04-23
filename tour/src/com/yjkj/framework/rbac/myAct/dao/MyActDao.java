package com.yjkj.framework.rbac.myAct.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.myAct.model.MyAct;

public interface MyActDao {

	public List<MyAct> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<MyAct> informationLoadAll(MyAct MyAct) throws Exception;
	
	public Integer count(MyAct MyAct) throws Exception;
	
	public MyAct informationLoadOne(MyAct MyAct) throws Exception;
	
	public void informationDelete(MyAct MyAct) throws Exception;
	
	public void informationAdd(MyAct MyAct) throws Exception;
	
	public void informationUpdate(MyAct MyAct) throws Exception;
	
}
