package com.yjkj.framework.base.basemodel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.rbac.about.dao.AboutDao;
import com.yjkj.framework.rbac.act.dao.ActDao;
import com.yjkj.framework.rbac.introduce.dao.IntroduceDao;
import com.yjkj.framework.rbac.myAct.dao.MyActDao;
import com.yjkj.framework.rbac.notice.dao.NoticeDao;
import com.yjkj.framework.rbac.personal.dao.PersonalDao;
import com.yjkj.framework.rbac.real.dao.RealDao;
@Service
public class BaseService {
	
	
	
	@Autowired
	public ActDao actDao;
	
	@Autowired
	public PersonalDao personalDao;
	
	@Autowired
	public RealDao realDao;
	
	@Autowired
	public MyActDao myActDao;
	
	@Autowired
	public AboutDao aboutDao;
	
	@Autowired
	public IntroduceDao introduceDao;
	
	@Autowired
	public NoticeDao noticeDao;
	
	
	

}
