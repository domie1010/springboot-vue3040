package com.yjkj.framework.rbac.act.service.inte;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.act.model.Act;

public interface ActService {

	public Pager informationLoad(Pager pager,Act Act,HttpSession session) throws Exception;
	
	public List<Act> informationLoadAll(Act Act) throws Exception;
	
	public Integer count(Act Act) throws Exception;
	
	public Act informationLoadOne(Act Act) throws Exception;
	
	public void informationDelete(Act Act) throws Exception;
	
	public void informationAdd(Act Act,MultipartFile[] file,HttpServletRequest request) throws Exception;
	
	public void informationUpade(Act Act,MultipartFile[] file,HttpServletRequest request) throws Exception;
	
}
