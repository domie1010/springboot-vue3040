package com.yjkj.framework.rbac.myAct.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.act.model.Act;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;


public class MyAct extends BaseModel{
	
	private String user_id;
	private String act_id;
	private Act act;
	private UserInfo userInfo;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public Act getAct() {
		return act;
	}
	public void setAct(Act act) {
		this.act = act;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
