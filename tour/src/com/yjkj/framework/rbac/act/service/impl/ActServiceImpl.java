package com.yjkj.framework.rbac.act.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.base.regular.file.OperaFile;
import com.yjkj.framework.rbac.act.model.Act;
import com.yjkj.framework.rbac.act.service.inte.ActService;
@Service
public class ActServiceImpl extends BaseService implements ActService {

	
	@Override
	public Pager informationLoad(Pager pager,Act Act,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("act", Act);
		List<Act> list = this.actDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Act));
		return pager;
	}

	@Override
	public List<Act> informationLoadAll(Act Act) throws Exception {
		List<Act> list = this.actDao.informationLoadAll(Act);
		return list;
	}
	

	@Override
	public Integer count(Act Act) throws Exception {
		Integer count = this.actDao.count(Act);
		return count;
	}

	@Override
	public Act informationLoadOne(Act Act) throws Exception {
			Act = this.actDao.informationLoadOne(Act);
		return Act;
	}

	@Override
	public void informationDelete(Act Act) throws Exception {
			this.actDao.informationDelete(Act);

	}

	@Override
	public void informationAdd(Act Act,MultipartFile[] file,HttpServletRequest request) throws Exception {
		Map<String, String> map = OperaFile.uploadFile(file, null, request);
		Act.setUrl(map.get("name"));
			Act.setId(Regular.createId());
			Act.setCreatetime(CreatDate.getDate());
			this.actDao.informationAdd(Act);

	}

	@Override
	public void informationUpade(Act Act,MultipartFile[] file,HttpServletRequest request) throws Exception {
		if(!file[0].isEmpty()) {
			Map<String, String> map = OperaFile.uploadFile(file, null, request);
			Act.setUrl(map.get("name"));
		}
			this.actDao.informationUpdate(Act);

	}

}
