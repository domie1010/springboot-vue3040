package com.yjkj.framework.rbac.personal.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.personal.model.Personal;

public interface PersonalService {

	public Pager informationLoad(Pager pager,Personal Personal,HttpSession session) throws Exception;
	
	public List<Personal> informationLoadAll(Personal Personal) throws Exception;
	
	public Integer count(Personal Personal) throws Exception;
	
	public Personal informationLoadOne(Personal Personal) throws Exception;
	
	public void informationDelete(Personal Personal) throws Exception;
	
	public void informationAdd(Personal Personal) throws Exception;
	
	public void informationUpade(Personal Personal) throws Exception;
	
}
