package com.yjkj.framework.rbac.myAct.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.myAct.model.MyAct;

public interface MyActService {

	public Pager informationLoad(Pager pager,MyAct MyAct,HttpSession session) throws Exception;
	
	public List<MyAct> informationLoadAll(MyAct MyAct) throws Exception;
	
	public Integer count(MyAct MyAct) throws Exception;
	
	public MyAct informationLoadOne(MyAct MyAct) throws Exception;
	
	public void informationDelete(MyAct MyAct) throws Exception;
	
	public void informationAdd(MyAct MyAct) throws Exception;
	
	public void informationUpade(MyAct MyAct) throws Exception;
	
}
